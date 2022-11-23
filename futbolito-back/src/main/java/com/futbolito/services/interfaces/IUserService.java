package com.futbolito.services.interfaces;

import java.util.Optional;

import com.futbolito.models.entidades.User;
import com.futbolito.security.dto.NewUser;

public interface IUserService extends ICRUD<User> {
	
	
	public Optional<User> getUserByUserName(String userName);

    public boolean existsByEmail(String email);
    
    public User createNewUser(NewUser newUser);

}
