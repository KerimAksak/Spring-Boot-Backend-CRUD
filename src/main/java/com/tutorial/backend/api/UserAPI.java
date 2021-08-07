package com.tutorial.backend.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.backend.dto.UserViewDTO;
import com.tutorial.backend.service.UserService;

import javassist.NotFoundException;

@RestController
@RequestMapping(path = "/api")
public class UserAPI {
	
	private final UserService userService;
	
	@Autowired
	public UserAPI(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping(path ="/v1/getUserById/{id}")
	public ResponseEntity<UserViewDTO> getUserById(@PathVariable Long id) throws NotFoundException {
		final UserViewDTO user = userService.getUserById(id);
		return ResponseEntity.ok(user);
	}

}
