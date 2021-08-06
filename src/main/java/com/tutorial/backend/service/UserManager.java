package com.tutorial.backend.service;

import org.springframework.stereotype.Service;

@Service
public class UserManager implements UserService {
	
	@Override
	public String hello() {
		return "Hello World!";
	}

}
