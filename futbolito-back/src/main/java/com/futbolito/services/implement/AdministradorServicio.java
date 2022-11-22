package com.futbolito.services.implement;

import java.util.List;

import org.springframework.stereotype.Service;

import com.futbolito.modelo.entidades.Administrator;
import com.futbolito.services.interfaces.IAdministradorServicio;

@Service
public class AdministradorServicio implements IAdministradorServicio {

	@Override
	public Administrator registrar(Administrator obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Administrator modificar(Administrator obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Administrator> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Administrator leerPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean eliminar(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
