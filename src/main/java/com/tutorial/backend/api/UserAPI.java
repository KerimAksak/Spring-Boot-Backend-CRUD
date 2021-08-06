package com.tutorial.backend.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.backend.service.UserService;

@RestController
@RequestMapping(path = "/api")
public class UserAPI {
	
	private final UserService userService;
	
	@Autowired
	public UserAPI(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping(path ="/v1/hello")
	public String hello() {
		return userService.hello();
	}

}
