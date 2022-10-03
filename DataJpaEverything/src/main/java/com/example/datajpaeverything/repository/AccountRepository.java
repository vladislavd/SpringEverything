package com.example.datajpaeverything.repository;

import com.example.datajpaeverything.domain.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import javax.persistence.LockModeType;

public interface AccountRepository extends JpaRepository<Account, Long> {

    @Override
    //is this annotation useful?
    @Lock(LockModeType.OPTIMISTIC_FORCE_INCREMENT)
    <S extends Account> S save(S entity);
}
