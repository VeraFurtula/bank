package com.learning.bank.service;

import com.learning.bank.dto.UserCreateDto;
import com.learning.bank.dto.UserResponseDto;
import com.learning.bank.dto.UserUpdateDto;
import jakarta.validation.Valid;

import java.util.List;

public interface UserService {
    public UserResponseDto findUserById(Long id);
    public List<UserResponseDto> findAllUsers();
    public void createUser(UserCreateDto userCreateDto);
    public void updateUser(Long id, UserCreateDto userUpdateDto);
    void deleteUser(Long id);


}
