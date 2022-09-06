package com.example.datajdbceverything.exception;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AccountManagerException extends RuntimeException {

    private final String message;

}
