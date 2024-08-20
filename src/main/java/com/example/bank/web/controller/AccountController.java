package com.example.bank.web.controller;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bank.service.AccountService;
import com.example.bank.web.dto.AccountDto;




@RestController
@RequestMapping("/api")
public class AccountController {
	
	private AccountService accountService;
	
	@Autowired
	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}
	 

	
	@PostMapping("/user/{userId}/account")
	public ResponseEntity<AccountDto> createAccount(@PathVariable(value = "userId") Long userId,
			@Valid @RequestBody AccountDto accountDto) {
		return new ResponseEntity<>(accountService.createAccount(userId, accountDto), HttpStatus.CREATED);
	}

    
	@GetMapping("/user/{userId}/accounts")
	public AccountDto getAccountByUserId(@PathVariable(value = "userId") Long userId) {
		return accountService.getAccountByUserId(userId);
	}

}
