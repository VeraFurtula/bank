package com.learning.bank.service.impl;

import com.learning.bank.exceptions.UserNotFoundException;
import com.learning.bank.model.User;
import com.learning.bank.repository.UserRepository;
import com.learning.bank.service.UserService;
import com.learning.bank.dto.UserCreateDto;
import com.learning.bank.dto.UserResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponseDto findUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return mapToResponseDto(user);
    }

    @Override
    public List<UserResponseDto> findAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public void createUser(UserCreateDto userCreateDto) {
        User user = new User();
        mapToEntity(userCreateDto, user);
        userRepository.save(user);
    }

    @Override
    public void updateUser(Long id, UserCreateDto userUpdateDto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        mapToEntity(userUpdateDto, user);
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found");
        }
        userRepository.deleteById(id);
    }

    private UserResponseDto mapToResponseDto(User user) {
        UserResponseDto dto = new UserResponseDto();
        dto.setId(user.getId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setAddress(user.getAddress());
        dto.setCity(user.getCity());
        dto.setZipCode(user.getZipCode());
        dto.setPhone(user.getPhone());
        dto.setEmail(user.getEmail());
        return dto;
    }

    private void mapToEntity(UserCreateDto dto, User user) {
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setAddress(dto.getAddress());
        user.setCity(dto.getCity());
        user.setZipCode(dto.getZipCode());
        user.setPhone(dto.getPhone());
        user.setEmail(dto.getEmail());
    }
}