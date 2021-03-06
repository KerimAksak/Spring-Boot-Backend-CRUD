package com.tutorial.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
	
	public User(String userName, String firstName, String lastName) {
		super();
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "user_name", nullable = false, length = 50, unique = true)
	private String userName;
	
	@Column(name = "first_name", nullable = false, length = 50)
	private String firstName;
	
	@Column(name = "last_name", nullable = false, length = 50)
	private String lastName;
	
}
