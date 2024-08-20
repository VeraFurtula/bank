package com.example.bank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bank.exceptions.AccountNotFoundException;
import com.example.bank.exceptions.UserNotFoundException;
import com.example.bank.model.Account;
import com.example.bank.model.User;
import com.example.bank.repository.AccountRepository;
import com.example.bank.repository.UserRepository;
import com.example.bank.service.AccountService;
import com.example.bank.web.dto.AccountDto;




@Service
public class AccountServiceImpl implements AccountService {
	
	private AccountRepository accountRepository;
	private UserRepository userRepository;
	
	@Autowired
	public AccountServiceImpl(AccountRepository accountRepository, UserRepository userRepository) {
		this.accountRepository = accountRepository;
		this.userRepository = userRepository;
	}
	
	

	private AccountDto mapToDto(Account account) {
		AccountDto accountDto = new AccountDto();
		accountDto.setId(account.getId());
		accountDto.setAccountNumber(account.getAccountNumber());
		accountDto.setBalance(account.getBalance());
		accountDto.setUserId(account.getUser().getId());

		return accountDto;
		
	}

	private Account mapToEntity(AccountDto accountDto) {
		Account account = new Account();
		account.setAccountNumber(accountDto.getAccountNumber());
        account.setBalance(accountDto.getBalance());
		
		return account;
	}

	@Override
	public AccountDto createAccount(Long userId, AccountDto accountDto) {
		Account account = mapToEntity(accountDto);
		User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User with associated account not found"));
		
		account.setUser(user);
		
		Account newAccount = accountRepository.save(account);
		
		return mapToDto(newAccount);
	}



	@Override
	public AccountDto getAccountByUserId(Long userId) {
		Account account = accountRepository.findByUserId(userId).stream().findFirst().orElseThrow(() -> new AccountNotFoundException("Account for user with ID " + userId + " not found"));
		return mapToDto(account);
	}
	
	

}
