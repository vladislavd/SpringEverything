package com.example.datajpaeverything.repository;

import com.example.datajpaeverything.domain.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
