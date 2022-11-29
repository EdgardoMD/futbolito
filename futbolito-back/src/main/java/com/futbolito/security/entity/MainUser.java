package com.futbolito.security.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.futbolito.models.entities.User;
import com.futbolito.models.entities.UserRole;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class MainUser implements UserDetails {

	private static final long serialVersionUID = 1L;
	private Long id;
    private String name;
    private String email;
    private String password;
    private String nick;
    private Collection<? extends GrantedAuthority> authorities;

    public MainUser(Long id, String name,  String email, String password, String nick, Collection<? extends GrantedAuthority> authorities) {
    	this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.nick = nick;
        this.authorities = authorities;
    }

    public static MainUser build(User user){
    	Set<UserRole> roles = user.getRoles();
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>() ;
        for (UserRole rol: roles) {
    		authorities.add(new SimpleGrantedAuthority(rol.getRole().getRole() ));
    	}
        
        
        return new MainUser(user.getIdUser(), user.getName(),  user.getMail(), user.getPassword(),user.getNickName(), authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return nick;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

	public Long getId() {
		return id;
	}

	public String getNick() {
		return nick;
	}
    
    
}
