package com.futbolito.security.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.futbolito.modelo.entidades.Usuario;
import com.futbolito.modelo.repositorio.IUsuarioRolRepositorio;
import com.futbolito.security.entity.UsuarioPrincipal;
import com.futbolito.servicio.interfaces.IUsuarioServicio;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IUsuarioServicio usuarioSer;
    
	@Autowired
	private IUsuarioRolRepositorio usuarioRolRepositorio;

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
    	System.out.println("*****************paso por aqui");
        Usuario usuario = usuarioSer.getByNombreUsuario(nombreUsuario).get();
        usuario.setRoles( usuarioRolRepositorio.listarRolesPorUsuario(usuario.getId()));
        
        System.out.println("*****************usuario que se crea" + usuario);
        return UsuarioPrincipal.build(usuario);
    }
}
