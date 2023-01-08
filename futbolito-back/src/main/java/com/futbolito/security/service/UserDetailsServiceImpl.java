package com.futbolito.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.futbolito.models.entities.User;
import com.futbolito.repository.IUserRoleRepository;
import com.futbolito.security.entity.MainUser;
import com.futbolito.services.interfaces.IUserService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IUserService usuarioSer;
    
	@Autowired
	private IUserRoleRepository usuarioRolRepositorio;

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        User usuario = usuarioSer.getUserByNickName(nombreUsuario.toLowerCase()).get();
        usuario.setRoles( usuarioRolRepositorio.listRoleByUserId(usuario.getIdUser()));
        
        return MainUser.build(usuario);
    }
}
