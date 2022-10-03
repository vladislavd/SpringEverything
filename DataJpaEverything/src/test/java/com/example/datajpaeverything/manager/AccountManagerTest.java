package com.example.datajpaeverything.manager;

import com.example.datajpaeverything.domain.dto.TransferDto;
import com.example.datajpaeverything.domain.model.Account;
import com.example.datajpaeverything.repository.AccountRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

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

        List<Future<?>> futures = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            futures.add(executorService.submit(() -> accountManager.makeTransfer(
                            createTransferDto(savedFrom.getId(),
                                    savedTo.getId(),
                                    BigDecimal.ONE)
                    )
            ));
        }
        executorService.awaitTermination(3, TimeUnit.SECONDS);

        futures.forEach(f -> {
            try {
                System.out.println("f.get() = " + f.get());
            } catch (InterruptedException e) {
                System.out.println("e.getMessage() = " + e.getMessage());
                System.out.println("e.getCause().getMessage() = " + e.getCause().getMessage());
            } catch (ExecutionException e) {
                System.out.println("e.getCause().getMessage() = " + e.getCause().getMessage());
                System.out.println("e.getMessage() = " + e.getMessage());
            }
        });

        Account resultFrom = accountRepository.findById(savedFrom.getId()).get();
        Account resultTo = accountRepository.findById(savedTo.getId()).get();
        System.out.println("resultTo = " + resultTo);
        System.out.println("resultFrom = " + resultFrom);

        Assertions.assertEquals(BigDecimal.ZERO, resultFrom.getAmount());
        Assertions.assertEquals(BigDecimal.valueOf(20L), resultTo.getAmount());
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