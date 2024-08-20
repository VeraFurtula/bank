package com.example.bank.service;

import com.example.bank.web.dto.UserDto;

public interface UserService {
	UserDto createUser(UserDto userDto);
	
	UserDto getUserById(long id);

	UserDto updateUser(UserDto userDto, long id);
	
	void deleteUserId(long id);
}
