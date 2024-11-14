package com.learning.bank.support;
import com.learning.bank.model.User;
import com.learning.bank.web.dto.AccountDTO;
import com.learning.bank.web.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class UserToUserDto implements Converter<User, UserDTO>{
    @Autowired
    private AccountToAccountDto toAccountDto;
    @Override
    public UserDTO convert(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPhone(user.getPhone());
        userDTO.setAddress(user.getAddress());
        userDTO.setCity(user.getCity());
        userDTO.setZipCode(user.getZipCode());

        if (user.getAccounts() != null) {
            List<AccountDTO> accountDTOs = toAccountDto.convert(user.getAccounts());
            userDTO.setAccounts(accountDTOs);
        }

        return userDTO;
    }

    public List<UserDTO> convert(List<User> users) {
        List<UserDTO> userDTOs = new ArrayList<>();
        for (User user : users) {
            userDTOs.add(convert(user));
        }
        return userDTOs;
    }
}
