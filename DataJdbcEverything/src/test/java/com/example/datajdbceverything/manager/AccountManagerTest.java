package com.example.datajdbceverything.manager;

import com.example.datajdbceverything.domain.dto.TransferDto;
import com.example.datajdbceverything.domain.model.Account;
import com.example.datajdbceverything.repository.AccountRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class AccountManagerTest {

    @Autowired
    private AccountManager accountManager;

    @Autowired
    private AccountRepository accountRepository;

    @Test
    void makeTransfer() throws InterruptedException {
        Account savedFrom = accountRepository.save(createAccount(null, BigDecimal.TEN));
        Account savedTo = accountRepository.save(createAccount(null, BigDecimal.TEN));
        ExecutorService executorService = Executors.newFixedThreadPool(8);
        System.out.println("savedTo = " + savedTo);
        System.out.println("savedFrom = " + savedFrom);

        for (int i = 0; i < 10; i++) {
            executorService.submit(
                    createTransferTask(
                            savedFrom.getId(),
                            savedTo.getId(),
                            BigDecimal.ONE)
            );
        }
        executorService.awaitTermination(5, TimeUnit.SECONDS);

        Account resultFrom = accountRepository.findById(savedFrom.getId()).get();
        Account resultTo = accountRepository.findById(savedTo.getId()).get();
        System.out.println("resultTo = " + resultTo);
        System.out.println("resultFrom = " + resultFrom);

        Assertions.assertEquals(BigDecimal.ZERO, resultFrom.getAmount());
        Assertions.assertEquals(BigDecimal.valueOf(20L), resultTo.getAmount());
    }

    private Runnable createTransferTask(Long fromId, long toId, BigDecimal amount) {
        return () -> accountManager
                .makeTransfer(
                createTransferDto(
                        fromId,
                        toId,
                        amount)
        );

    }

    private TransferDto createTransferDto(long from, long to, BigDecimal amount) {
        return new TransferDto(from, to, amount);
    }

    private Account createAccount(Long id, BigDecimal amount) {
        Account account = new Account();
        account.setId(id);
        account.setAmount(amount);
        return account;
    }
}