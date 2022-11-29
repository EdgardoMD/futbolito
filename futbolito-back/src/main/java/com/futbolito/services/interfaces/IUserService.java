package com.futbolito.services.interfaces;

import java.util.Optional;

import com.futbolito.models.entities.User;
import com.futbolito.security.dto.NewUser;

public interface IUserService extends ICRUD<User> {
	
	
	public Optional<User> getUserByNickName(String userName);

    public boolean existsByEmail(String email);
    
    public boolean existsByNickName(String nickName);
    
    public User createNewUser(NewUser newUser);

}
