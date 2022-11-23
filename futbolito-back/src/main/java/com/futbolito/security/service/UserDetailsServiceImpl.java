package com.futbolito.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.futbolito.models.entidades.User;
import com.futbolito.repository.IUserRoleRepository;
import com.futbolito.security.entity.MainUser;
import com.futbolito.services.interfaces.IUsuarioServicio;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IUsuarioServicio usuarioSer;
    
	@Autowired
	private IUserRoleRepository usuarioRolRepositorio;

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        User usuario = usuarioSer.getByNombreUsuario(nombreUsuario).get();
        usuario.setRoles( usuarioRolRepositorio.listRoleByUserId(usuario.getIdUser()));
        
        return MainUser.build(usuario);
    }
}
