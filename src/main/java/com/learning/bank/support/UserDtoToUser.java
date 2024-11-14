package com.learning.bank.support;

import com.learning.bank.model.User;
import com.learning.bank.service.UserService;
import com.learning.bank.web.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserDtoToUser implements Converter<UserDTO, User> {
    @Autowired
    private UserService userService;

    @Override
    public User convert(UserDTO dto) {
        User user;

        if (dto.getId() == null) {
            user = new User();
        } else {
            user = userService.findOne(dto.getId());
            if (user == null) {
                user = new User();
            }
        }

        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        user.setPhone(dto.getPhone());
        user.setAddress(dto.getAddress());
        user.setCity(dto.getCity());
        user.setZipCode(dto.getZipCode());



        return user;
    }


}
