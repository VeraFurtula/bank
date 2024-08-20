package com.example.bank.service;

import com.example.bank.web.dto.AccountDto;

public interface AccountService {
	
	AccountDto createAccount(Long userId, AccountDto accountDto);
	AccountDto getAccountByUserId(Long userId);

}
