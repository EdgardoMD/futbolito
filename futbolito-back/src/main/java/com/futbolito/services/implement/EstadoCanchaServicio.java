package com.futbolito.services.implement;

import java.util.List;

import org.springframework.stereotype.Service;

import com.futbolito.modelo.entidades.StatusCourt;
import com.futbolito.services.interfaces.IEstadoCanchaServicio;

@Service
public class EstadoCanchaServicio implements IEstadoCanchaServicio {

	@Override
	public StatusCourt registrar(StatusCourt obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StatusCourt modificar(StatusCourt obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StatusCourt> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StatusCourt leerPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean eliminar(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
