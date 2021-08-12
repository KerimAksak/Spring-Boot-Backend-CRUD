package com.tutorial.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tutorial.backend.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	boolean existsUserByUserName(String userName);

}
