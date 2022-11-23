package com.futbolito.services.implement;

import java.util.List;

import org.springframework.stereotype.Service;

import com.futbolito.models.entidades.Match;
import com.futbolito.services.interfaces.IPartidoServicio;

@Service
public class PartidoServicio implements IPartidoServicio {

	@Override
	public Match registrar(Match obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Match modificar(Match obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Match> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Match leerPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean eliminar(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
