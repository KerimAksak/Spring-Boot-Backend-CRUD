package com.tutorial.backend.service;

import com.tutorial.backend.dto.UserViewDTO;

import javassist.NotFoundException;

public interface UserService {
	UserViewDTO getUserById(Long id) throws NotFoundException;
}
