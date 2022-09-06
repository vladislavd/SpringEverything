package com.example.datajdbceverything.domain.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

@Table("account")
@Getter
@Setter
@ToString
public class Account {

    @Id
    private Long id;
    private BigDecimal amount;
}
