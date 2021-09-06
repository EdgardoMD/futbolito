package com.futbolito.servicio.implementaciones;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.futbolito.modelo.entidades.Rol;
import com.futbolito.modelo.repositorio.IRolRepositorio;
import com.futbolito.servicio.interfaces.IRolUsuarioServicio;

@Service
public class RolUsuarioServicio implements IRolUsuarioServicio {

	@Autowired
	private IRolRepositorio RolUsuarioRep;

	@Override
	public Rol registrar(Rol obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rol modificar(Rol obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Rol> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rol leerPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean eliminar(Long id) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void save(Rol rol) {
		RolUsuarioRep.save(rol);
	}

}
