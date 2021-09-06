package com.futbolito.servicio.implementaciones;

import java.util.List;

import org.springframework.stereotype.Service;

import com.futbolito.modelo.entidades.Ciudad;
import com.futbolito.servicio.interfaces.ICiudadServicio;

@Service
public class CiudadServicio implements ICiudadServicio {

	@Override
	public Ciudad registrar(Ciudad obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ciudad modificar(Ciudad obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ciudad> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ciudad leerPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean eliminar(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
