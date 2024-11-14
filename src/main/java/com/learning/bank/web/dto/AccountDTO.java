package com.learning.bank.web.dto;

import com.learning.bank.model.User;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;


public class AccountDTO {
    private Long id;

    @NotNull
    private String accountNumber;

    @NotNull
    @Positive(message = "Balance should be positive number")
    private double balance;

    @Positive(message = "Id should be positive number")
    @NotNull
    private Long userId;

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
