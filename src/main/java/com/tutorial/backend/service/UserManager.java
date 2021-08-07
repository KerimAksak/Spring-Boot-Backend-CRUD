package com.tutorial.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutorial.backend.dto.UserCreateDTO;
import com.tutorial.backend.dto.UserViewDTO;
import com.tutorial.backend.model.User;
import com.tutorial.backend.repository.UserRepository;

import javassist.NotFoundException;

@Service
public class UserManager implements UserService {
	
	private final UserRepository userRepository;
	
	@Autowired
	public UserManager(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserViewDTO getUserById(Long id) throws NotFoundException {
		final User user = userRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Not Found"));
		return UserViewDTO.of(user);
	}

	@Override
	public UserViewDTO createUser(UserCreateDTO userCreateDTO) {
		final User user = userRepository
				.save(new User(userCreateDTO.getFirstName(), userCreateDTO.getLastName()));
		return UserViewDTO.of(user);
	}
	

}
