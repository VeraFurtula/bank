package com.learning.bank.service;

import com.learning.bank.dto.UserCreateDto;
import com.learning.bank.dto.UserResponseDto;
import com.learning.bank.dto.UserUpdateDto;

import java.util.List;

public interface UserService {
    UserResponseDto findUserById(Long id);
    List<UserResponseDto> findAllUsers();
    UserResponseDto createUser(UserCreateDto userCreateDto);
    UserResponseDto updateUser(Long id, UserUpdateDto userUpdateDto);
    void deleteUser(Long id);
}
