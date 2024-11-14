package com.learning.bank.service.impl;

import com.learning.bank.model.Account;
import com.learning.bank.repository.AccountRepository;
import com.learning.bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {}

    @Override
    public Account findOne(Long id) {
        return accountRepository.findOneById(id);
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account update(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account delete(Long id) {
        Optional<Account> accountOptional = accountRepository.findById(id);
        if (accountOptional.isPresent()) {
            accountRepository.deleteById(id);
            return accountOptional.get();
        }
        return null;
    }

    @Override
    public List<Account> findByAccountId(Long accountId) {
        return accountRepository.findByUserId(accountId);
    }
}
