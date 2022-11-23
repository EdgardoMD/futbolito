package com.futbolito.services.interfaces;

import java.util.Optional;

import com.futbolito.models.entidades.User;
import com.futbolito.security.dto.NewUser;

public interface IUsuarioServicio extends ICRUD<User> {
	
	
	public Optional<User> getByNombreUsuario(String nombreUsuario);

    public boolean existsByEmail(String email);
    
    public User crearNuevoUsuario(NewUser nuevoUsuario);

}
