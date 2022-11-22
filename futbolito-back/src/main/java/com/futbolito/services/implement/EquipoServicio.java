package com.futbolito.services.implement;

import java.util.List;

import org.springframework.stereotype.Service;

import com.futbolito.modelo.entidades.Team;
import com.futbolito.services.interfaces.IEquipoServicio;

@Service
public class EquipoServicio implements IEquipoServicio {

	@Override
	public Team registrar(Team obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Team modificar(Team obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Team> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Team leerPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean eliminar(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
