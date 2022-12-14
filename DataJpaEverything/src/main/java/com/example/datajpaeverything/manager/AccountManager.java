package com.example.datajpaeverything.manager;

import com.example.datajpaeverything.domain.dto.TransferDto;
import com.example.datajpaeverything.domain.model.Account;
import com.example.datajpaeverything.exception.AccountManagerException;
import com.example.datajpaeverything.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountManager {

    public static final String ACCOUNT_S_NOT_FOUND = "Account %s not found.";
    public static final String ACCOUNT_S_HAS_NOT_ENOUGH_MONEY = "Account %s has not enough money.";
    private final AccountRepository accountRepository;


//    @Retryable(
//            backoff = @Backoff(delay = 100, maxDelay = 300),
//            maxAttempts = 10)
    @Transactional
    public void makeTransfer(TransferDto transfer) {
        final Account accountTo = accountRepository.findById(transfer.accountTo())
                .orElseThrow(() -> new AccountManagerException(ACCOUNT_S_NOT_FOUND.formatted(transfer.accountTo())));
        final Account accountFrom = accountRepository.findById(transfer.accountFrom())
                .orElseThrow(() -> new AccountManagerException(ACCOUNT_S_NOT_FOUND.formatted(transfer.accountFrom())));
        log.debug("makeTransfer accountTo = {}", accountTo);
        log.debug("makeTransfer accountFrom = {}", accountFrom);
        if (accountFrom.getAmount().compareTo(transfer.amount()) < 0) {
            throw new AccountManagerException(ACCOUNT_S_HAS_NOT_ENOUGH_MONEY.formatted(accountFrom.getId()));
        }
        BigDecimal newAccountFromAmount = accountFrom.getAmount().subtract(transfer.amount());
        BigDecimal newAccountToAmount = accountTo.getAmount().add(transfer.amount());
        accountTo.setAmount(newAccountToAmount);
        accountFrom.setAmount(newAccountFromAmount);
        Account savedTo = accountRepository.save(accountTo);
        Account savedFrom = accountRepository.save(accountFrom);
        log.debug("makeTransfer savedTo = {}", savedTo);
        log.debug("makeTransfer savedFrom = {}", savedFrom);
    }
}
