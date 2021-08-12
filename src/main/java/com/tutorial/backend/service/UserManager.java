package com.tutorial.backend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tutorial.backend.dto.UserCreateDTO;
import com.tutorial.backend.dto.UserUpdateDTO;
import com.tutorial.backend.dto.UserViewDTO;
import com.tutorial.backend.model.User;
import com.tutorial.backend.repository.UserRepository;

import javassist.NotFoundException;

@Service
public class UserManager implements UserService {
	
	private final UserRepository userRepository;
	
	@Autowired
	public UserManager(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public UserViewDTO getUserById(Long id) throws NotFoundException {
		final User user = userRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Not Found"));
		return UserViewDTO.of(user);
	}

	@Override
	public UserViewDTO createUser(UserCreateDTO userCreateDTO) {
		final User user = userRepository
				.save(new User(userCreateDTO.getUserName(), userCreateDTO.getFirstName(), userCreateDTO.getLastName()));
		return UserViewDTO.of(user);
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<UserViewDTO> getAllUsers() {
		return userRepository.findAll()
				.stream()
				.map(user -> UserViewDTO.of(user))
				.collect(Collectors.toList());
	}
	
	@Override
	@Transactional
	public UserViewDTO updateUser(Long id, UserUpdateDTO userUpdateDTO) throws NotFoundException {
		final User user = userRepository
				.findById(id)
				.orElseThrow(() -> new NotFoundException("Not Found!"));
		user.setFirstName(userUpdateDTO.getFirstName());
		user.setLastName(userUpdateDTO.getLastName());
		return UserViewDTO.of(userRepository.save(user));
	}
	
	@Override
	@Transactional
	public void deleteUser(Long id) throws NotFoundException {
		final User user = userRepository
				.findById(id)
				.orElseThrow(() -> new NotFoundException("Not Found User"));
		userRepository.deleteById(user.getId());
	}
	
	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<UserViewDTO> userSlice(Pageable pageable) {
		return userRepository.findAll(pageable).stream()
				.map(user -> UserViewDTO.of(user)).collect(Collectors.toList());
	}
	
}
