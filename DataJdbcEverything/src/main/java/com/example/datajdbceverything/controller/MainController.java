package com.example.datajdbceverything.controller;

import com.example.datajdbceverything.domain.dto.TransferDto;
import com.example.datajdbceverything.manager.AccountManager;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/main")
@RequiredArgsConstructor
public class MainController {

    private final AccountManager accountManager;

    // todo add response
    @PostMapping("/transfer")
    public void makeTransfer(@RequestBody TransferDto transfer) {
        accountManager.makeTransfer(transfer);
    }

}
