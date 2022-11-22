package com.futbolito.services.implement;

import java.util.List;

import org.springframework.stereotype.Service;

import com.futbolito.modelo.entidades.Score;
import com.futbolito.services.interfaces.IPuntajeServicio;

@Service
public class PuntajeServicio implements IPuntajeServicio {

	@Override
	public Score registrar(Score obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Score modificar(Score obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Score> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Score leerPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean eliminar(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
