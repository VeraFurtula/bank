package com.learning.bank.service;

import com.learning.bank.model.Account;

import java.util.List;

public interface AccountService {
    Account findOne(Long id);
    List<Account> findAll();
    Account save(Account account);
    Account update(Account account);
    Account delete(Long id);
    List<Account> findByAccountId(Long accountId);
}
