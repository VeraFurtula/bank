package com.learning.bank.service;

import com.learning.bank.dto.AccountDto;

import java.util.List;


public interface AccountService {
    List<AccountDto> findAll();
    AccountDto findById(Long id);
    void save(AccountDto accountDto);
    void update(Long id, AccountDto accountDto);
    void delete(Long id);
}
