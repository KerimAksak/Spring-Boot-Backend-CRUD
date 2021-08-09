package com.tutorial.backend.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class UserUpdateDTO {
	
	@NotNull(message = "{backend.validation.constraints.firstname.NotNull.message}")
	@Size(min = 4, max = 32, 
			message = "{backend.validation.constraints.firstname.Size.message}")
	private String firstName;
	
	@NotNull(message = "{backend.validation.constraints.firstname.NotNull.message}")
	@Size(min = 4, max = 32, 
			message = "{backend.validation.constraints.firstname.Size.message}")
	private String lastName;

}
