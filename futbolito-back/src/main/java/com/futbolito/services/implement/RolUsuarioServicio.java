package com.futbolito.services.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.futbolito.models.entidades.Role;
import com.futbolito.repository.IRoleRepository;
import com.futbolito.services.interfaces.IRolUsuarioServicio;

@Service
public class RolUsuarioServicio implements IRolUsuarioServicio {

	@Autowired
	private IRoleRepository RolUsuarioRep;

	@Override
	public Role registrar(Role obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Role modificar(Role obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Role leerPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean eliminar(Long id) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void save(Role rol) {
		RolUsuarioRep.save(rol);
	}

}
