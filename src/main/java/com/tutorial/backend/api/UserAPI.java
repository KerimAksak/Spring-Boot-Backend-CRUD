package com.tutorial.backend.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.backend.dto.UserCreateDTO;
import com.tutorial.backend.dto.UserUpdateDTO;
import com.tutorial.backend.dto.UserViewDTO;
import com.tutorial.backend.service.UserService;
import com.tutorial.backend.shared.GenericResponse;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
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
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public ResponseEntity<UserViewDTO> getUserById(@PathVariable Long id) throws NotFoundException {
		final UserViewDTO user = userService.getUserById(id);
		return ResponseEntity.ok(user);
	}
	
	@PostMapping(path="/v1/createuser")
	@Transactional
	public ResponseEntity<?> createUser(@RequestBody UserCreateDTO userCreateDTO){
		userService.createUser(userCreateDTO);	
		return ResponseEntity.ok(new GenericResponse("Registration Successful"));
	}
		
	@GetMapping(path = "/v1/getAllUsers")
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public ResponseEntity<List<UserViewDTO>> getAllUsers(){
		return ResponseEntity.ok(userService.getAllUsers());
	}

	@PutMapping(path = "/v1/userUpdate/{id}")
	public ResponseEntity<UserViewDTO> userUpdate(@PathVariable("id") Long id, 
			@RequestBody UserUpdateDTO UserUpdateDTO) throws NotFoundException{
		return ResponseEntity.ok(userService.updateUser(id, UserUpdateDTO));
	}
	
	@DeleteMapping(path = "/v1/deleteUser/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable("id") Long id){
		userService.deleteUser(id);
		return ResponseEntity.ok(new GenericResponse("User Deleted!"));
	}

}
