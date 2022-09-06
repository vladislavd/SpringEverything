package com.example.datajpaeverything.exception;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AccountManagerException extends RuntimeException {

    private final String message;

}
