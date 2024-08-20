package com.example.bank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bank.exceptions.UserNotFoundException;
import com.example.bank.model.User;
import com.example.bank.repository.UserRepository;
import com.example.bank.service.UserService;
import com.example.bank.web.dto.UserDto;



@Service
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDto createUser(UserDto userDto) {
		User user = new User();
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setAdress(userDto.getAdress());
		user.setCity(userDto.getCity());
		user.setZipCode(userDto.getZipCode());
		user.setPhone(userDto.getPhone());
		user.setEmail(userDto.getEmail());
		
		User newUser = userRepository.save(user);
		
		UserDto userResponse = new UserDto();
		userResponse.setId(newUser.getId());
		userResponse.setFirstName(newUser.getFirstName());	
		userResponse.setLastName(newUser.getLastName());
		userResponse.setAdress(newUser.getAdress());
		userResponse.setCity(newUser.getCity());
		userResponse.setZipCode(newUser.getZipCode());
		userResponse.setPhone(newUser.getPhone());
		userResponse.setEmail(newUser.getEmail());

		return userResponse;
	}

	private UserDto mapToDto(User user) {
		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setFirstName(user.getFirstName());	
		userDto.setLastName(user.getLastName());
		userDto.setAdress(user.getAdress());
		userDto.setCity(user.getCity());
		userDto.setZipCode(user.getZipCode());
		userDto.setPhone(user.getPhone());
		userDto.setEmail(user.getEmail());
		
		return userDto;
		
	}
	
	private User mapToEntity(UserDto userDto) {
		User user = new User();
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setAdress(userDto.getAdress());
		user.setCity(userDto.getCity());
		user.setZipCode(userDto.getZipCode());
		user.setPhone(userDto.getPhone());
		user.setEmail(userDto.getEmail());
		
		return user;
	}
	
	@Override
	public UserDto getUserById(long id) {
		User user = userRepository.findById(id).orElseThrow(()-> new UserNotFoundException("User could not be found"));
		return mapToDto(user);
	}

	@Override
	public UserDto updateUser(UserDto userDto, long id) {
		User user = userRepository.findById(id).orElseThrow(()-> new UserNotFoundException("User could not be updated"));
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setAdress(userDto.getAdress());
		user.setCity(userDto.getCity());
		user.setZipCode(userDto.getZipCode());
		user.setPhone(userDto.getPhone());
		user.setEmail(userDto.getEmail());
		
		User updatedUser = userRepository.save(user);
		
		return mapToDto(updatedUser);
	}

	@Override
	public void deleteUserId(long id) {
		User user = userRepository.findById(id).orElseThrow(()-> new UserNotFoundException("User could not be deleted"));
		userRepository.delete(user);

	}

}
