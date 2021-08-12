package com.tutorial.backend.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public final class UserCreateDTO {
	
	@NotNull(message = "{backend.validation.constraints.username.NotNull.message}")
	@Size(min = 4, max = 32, 
			message = "{backend.validation.constraints.username.Size.message}")
	private String userName;
	
	@NotNull(message = "{backend.validation.constraints.firstname.NotNull.message}")
	@Size(min = 4, max = 32, 
			message = "{backend.validation.constraints.firstname.Size.message}")
	private String firstName;
	
	@NotNull(message = "{backend.validation.constraints.lastname.NotNull.message}")
	@Size(min = 4, max = 32, 
			message = "{backend.validation.constraints.lastname.Size.message}")
	private String lastName;
	
	
}
