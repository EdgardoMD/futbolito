package com.futbolito.modelo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.modelo.entidades.User;

public interface IUsuarioRepositorio extends JpaRepository<User, Long> {
	
	Optional<User> findByMail(String userName);
    boolean existsByMail(String email);

}
