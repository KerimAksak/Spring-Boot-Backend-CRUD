package com.tutorial.backend.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.tutorial.backend.repository.UserRepository;

public final class UniqueUserNameValidator implements ConstraintValidator<UniqueUserName, String> {

	private final UserRepository userRepository;
	
	public UniqueUserNameValidator(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public boolean isValid(String userName, ConstraintValidatorContext context) {
		return !userRepository.existsUserByUserName(userName);
	}

}
	