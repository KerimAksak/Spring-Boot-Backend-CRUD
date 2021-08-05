package com.tutorial.backend.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class UserAPI {
	
	@GetMapping(path ="/v1/hello")
	public String hello() {
		return "Hello World!";
	}

}
