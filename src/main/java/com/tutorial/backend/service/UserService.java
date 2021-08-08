package com.tutorial.backend.service;

import java.util.List;

import com.tutorial.backend.dto.UserCreateDTO;
import com.tutorial.backend.dto.UserViewDTO;

import javassist.NotFoundException;

public interface UserService {
	UserViewDTO getUserById(Long id) throws NotFoundException;
	
	UserViewDTO createUser(UserCreateDTO userCreateDTO);

	List<UserViewDTO> getAllUsers();
}
