package com.learning.bank.service.impl;

import com.learning.bank.exceptions.UserNotFoundException;
import com.learning.bank.model.User;
import com.learning.bank.repository.UserRepository;
import com.learning.bank.service.UserService;
import com.learning.bank.dto.UserCreateDto;
import com.learning.bank.dto.UserResponseDto;
import com.learning.bank.dto.UserUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponseDto findUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
        return mapToResponseDto(user);
    }

    @Override
    public List<UserResponseDto> findAllUsers() {
        return userRepository.findAll().stream().map(this::mapToResponseDto).collect(Collectors.toList());
    }


    @Override
    public UserResponseDto createUser(UserCreateDto userCreateDto) {
        User user = mapToEntity(userCreateDto);
        User savedUser = userRepository.save(user);
        return mapToResponseDto(savedUser);
    }

    @Override
    public UserResponseDto updateUser(Long id, UserUpdateDto userUpdateDto) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
        user.setFirstName(userUpdateDto.getFirstName());
        user.setLastName(userUpdateDto.getLastName());
        user.setAddress(userUpdateDto.getAddress());
        user.setCity(userUpdateDto.getCity());
        user.setZipCode(userUpdateDto.getZipCode());
        user.setPhone(userUpdateDto.getPhone());
        user.setEmail(userUpdateDto.getEmail());
        User updatedUser = userRepository.save(user);
        return mapToResponseDto(updatedUser);
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
        userRepository.delete(user);
    }

    private User mapToEntity(UserCreateDto dto) {
        User user = new User();
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        return user;
    }

    private UserResponseDto mapToResponseDto(User user) {
        UserResponseDto dto = new UserResponseDto();
        dto.setId(user.getId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setEmail(user.getEmail());
        return dto;
    }
}
