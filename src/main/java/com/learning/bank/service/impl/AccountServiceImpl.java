package com.learning.bank.service.impl;

import com.learning.bank.model.Account;
import com.learning.bank.repository.AccountRepository;
import com.learning.bank.service.AccountService;
import com.learning.bank.dto.AccountDto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<AccountDto> findAll() {
        return accountRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public AccountDto findById(Long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid account ID: " + id));
        return convertToDto(account);
    }

    @Override
    @Transactional
    public void save(AccountDto accountDto) {
        Account account = convertToEntity(accountDto);
        accountRepository.save(account);
    }

    @Override
    @Transactional
    public void update(Long id, AccountDto accountDto) {
        Account existingAccount = accountRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid account ID: " + id));
        existingAccount.setAccountNumber(accountDto.getAccountNumber());
        existingAccount.setBalance(accountDto.getBalance());
        accountRepository.save(existingAccount);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        accountRepository.deleteById(id);
    }

    private AccountDto convertToDto(Account account) {
        AccountDto dto = new AccountDto();
        dto.setId(account.getId());
        dto.setAccountNumber(account.getAccountNumber());
        dto.setBalance(account.getBalance());
        return dto;
    }

    private Account convertToEntity(AccountDto accountDto) {
        Account account = new Account();
        account.setId(accountDto.getId());
        account.setAccountNumber(accountDto.getAccountNumber());
        account.setBalance(accountDto.getBalance());
        return account;
    }
}