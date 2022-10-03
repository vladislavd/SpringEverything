package com.example.datajdbceverything.repository;

import com.example.datajdbceverything.domain.model.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {

    @Override
    <S extends Account> S save(S entity);
}
