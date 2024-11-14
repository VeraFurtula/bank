package com.learning.bank.support;

import com.learning.bank.model.Account;
import com.learning.bank.service.AccountService;
import com.learning.bank.service.UserService;
import com.learning.bank.web.dto.AccountDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;

@Component
public class AccountDtoToAccount implements Converter<AccountDTO, Account> {
    @Autowired
    private AccountService accountService;

    @Autowired
    private UserService userService;

    @Override
    public Account convert(AccountDTO accountDTO) {
        Account account;

        if(accountDTO.getId() == null){
            account = new Account();
        } else {
            account = accountService.findOne(accountDTO.getId());
        }
        if(account != null){
            account.setBalance(accountDTO.getBalance());
            account.setAccountNumber(accountDTO.getAccountNumber());
            account.setUser(userService.findOne(accountDTO.getUserId()));
        }
        return account;
    }

}
