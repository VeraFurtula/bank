package com.example.bank.web.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public class AccountDto {
    private Long id;
    
    @Pattern(regexp = "^[0-9]{3}-[0-9]{13}-[0-9]{2}$", message = "Invalid account number format")
    private String accountNumber;
    
    @NotNull(message = "Balance cannot be null")
    @Positive(message = "Balance must be positive")
    private double balance;
    
    @NotNull(message = "User ID cannot be null")
    private Long userId;
    
    // konstruktori
	public AccountDto(Long id, String accountNumber, double balance, Long userId) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.userId = userId;
	}

	public AccountDto() {
		super();
	}

	//getteri i setteri
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
    
    
	
}
