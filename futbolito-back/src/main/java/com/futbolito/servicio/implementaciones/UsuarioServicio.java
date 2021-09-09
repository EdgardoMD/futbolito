package com.futbolito.servicio.implementaciones;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.futbolito.modelo.entidades.Usuario;
import com.futbolito.modelo.entidades.UsuarioRol;
import com.futbolito.modelo.repositorio.IRolRepositorio;
import com.futbolito.modelo.repositorio.IUsuarioRepositorio;
import com.futbolito.modelo.repositorio.IUsuarioRolRepositorio;
import com.futbolito.security.dto.NuevoUsuario;
import com.futbolito.servicio.interfaces.IUsuarioServicio;

@Service
public class UsuarioServicio implements IUsuarioServicio {

	@Autowired
	private IUsuarioRepositorio UsuarioRep;
	
	@Autowired
	private IUsuarioRolRepositorio UsuarioRolRep;
	
	@Autowired
	private IRolRepositorio rolRep;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	private static final int ID_ROL_DEPORTISTA = 1;

	@Override
	public Usuario registrar(Usuario obj) {

		return UsuarioRep.save(obj);
	}

	@Override
	public Usuario modificar(Usuario obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario leerPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean eliminar(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Optional<Usuario> getByNombreUsuario(String nombreUsuario) {
		return UsuarioRep.findByMail(nombreUsuario);
	}

	@Override
	public boolean existsByEmail(String email) {
		return UsuarioRep.existsByMail(email);
	}

	@Override
	@Transactional
	public Usuario crearNuevoUsuario(NuevoUsuario nuevoUsuario) {

		Usuario usuario = new Usuario();
		usuario.setMail(nuevoUsuario.getEmail());
		usuario.setNombre(nuevoUsuario.getNombre());
		usuario.setPassword( passwordEncoder.encode(nuevoUsuario.getPassword()));
		usuario.setTelefono(nuevoUsuario.getTelefono());
		Usuario usuarioRegistrado = registrar(usuario);
		UsuarioRol rolUsuario = new UsuarioRol();
		rolUsuario.setUsuario(usuarioRegistrado);
		rolUsuario.setRol(rolRep.findById(ID_ROL_DEPORTISTA).get());
		UsuarioRolRep.save(rolUsuario);
		return UsuarioRep.findById(usuarioRegistrado.getId()).get();
	}

}
