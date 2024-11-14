package com.learning.bank.support;

import com.learning.bank.model.Account;
import com.learning.bank.web.dto.AccountDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountToAccountDto implements Converter<Account, AccountDTO> {
    @Override
    public AccountDTO convert(Account account){
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setId(account.getId());
        accountDTO.setBalance(account.getBalance());
        accountDTO.setAccountNumber(account.getAccountNumber());
        accountDTO.setUserId(account.getUser().getId());

        return accountDTO;

    }

    public List<AccountDTO> convert(List<Account> accounts){
        List<AccountDTO> accountDTOS = new ArrayList<>();
        for(Account account : accounts){
            accountDTOS.add(convert(account));
        }
        return accountDTOS;
    }
}
