package com.tutorial.backend.dto;

import javax.validation.constraints.Size;

import lombok.Data;

@Data
public final class UserCreateDTO {
	
	@Size(min = 4, max = 32, message = "First Name should be length min 4-max 32.")
	private String firstName;
	
	private String lastName;
	
	
}
