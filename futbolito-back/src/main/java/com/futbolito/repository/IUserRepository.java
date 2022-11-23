package com.futbolito.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.models.entidades.User;

public interface IUserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByMail(String userName);
    boolean existsByMail(String email);

}
