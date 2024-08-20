package com.example.bank.model;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Account {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
	@Pattern(regexp = "^[0-9]{3}-[0-9]{13}-[0-9]{2}$", message = "Invalid account number format")
	private String accountNumber;
	
	@NotNull(message = "Balance cannot be null")
	@Positive(message = "Balance must be positive")
    private double balance;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    
    // konstruktori
    public Account(Long id, String accountNumber, double balance, User user) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.user = user;
	}
    
    
    
    public Account() {
		super();
	}



	// getteri i setteri
	public Long getId() {
		return id;
	}

	

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}



	@Override
	public String toString() {
		return "Account [id=" + id + ", accountNumber=" + accountNumber + ", balance=" + balance + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Account))
			return false;
		Account other = (Account) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

   
}
