package com.futbolito.servicio.interfaces;

import java.util.Optional;

import com.futbolito.modelo.entidades.Usuario;
import com.futbolito.security.dto.NuevoUsuario;

public interface IUsuarioServicio extends ICRUD<Usuario> {
	
	
	public Optional<Usuario> getByNombreUsuario(String nombreUsuario);

    public boolean existsByEmail(String email);
    
    public Usuario crearNuevoUsuario(NuevoUsuario nuevoUsuario);

}
