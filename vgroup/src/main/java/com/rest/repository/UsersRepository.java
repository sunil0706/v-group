package com.rest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.model.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {
	
    Optional<Users> findByName(String username);
}
