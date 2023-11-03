package com.deviot.cropmasterbackend.account.infrastructure.repositories;

import com.deviot.cropmasterbackend.account.domain.model.aggregates.Account;
import com.deviot.cropmasterbackend.account.domain.model.enums.AccountRol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {

    Optional<Account> findByEmail(String email);
    Optional<List<Account>> findAccountsByRol(AccountRol roll);

}
