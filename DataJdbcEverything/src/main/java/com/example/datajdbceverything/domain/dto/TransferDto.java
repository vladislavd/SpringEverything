package com.example.datajdbceverything.domain.dto;

import java.math.BigDecimal;

public record TransferDto(long accountFrom, long accountTo, BigDecimal amount) { }
