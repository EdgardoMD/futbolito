package com.futbolito.servicio.implementaciones;

import java.util.List;

import org.springframework.stereotype.Service;

import com.futbolito.modelo.entidades.Partido;
import com.futbolito.servicio.interfaces.IPartidoServicio;

@Service
public class PartidoServicio implements IPartidoServicio {

	@Override
	public Partido registrar(Partido obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Partido modificar(Partido obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Partido> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Partido leerPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean eliminar(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
