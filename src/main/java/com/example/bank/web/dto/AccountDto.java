package com.example.bank.web.dto;

public class AccountDto {
    private Long id;
    
    private String accountNumber;
    
    private double balance;
    
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
