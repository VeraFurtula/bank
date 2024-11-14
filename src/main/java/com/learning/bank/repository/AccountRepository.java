package com.learning.bank.repository;

import com.learning.bank.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findOneById(Long id);
    List<Account> findByUserId(Long userId);
}
