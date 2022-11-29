package com.futbolito.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.models.entities.User;

public interface IUserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByNickName(String nickName);
    boolean existsByMail(String email);
    boolean existsByNickName(String nickName);

    
    
}
