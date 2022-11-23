package com.futbolito.services.implement;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.futbolito.models.entidades.User;
import com.futbolito.models.entidades.UserRole;
import com.futbolito.repository.IRoleRepository;
import com.futbolito.repository.IUserRepository;
import com.futbolito.repository.IUserRoleRepository;
import com.futbolito.security.dto.NewUser;
import com.futbolito.services.interfaces.IUsuarioServicio;

@Service
public class UsuarioServicio implements IUsuarioServicio {

	@Autowired
	private IUserRepository UsuarioRep;
	
	@Autowired
	private IUserRoleRepository UsuarioRolRep;
	
	@Autowired
	private IRoleRepository rolRep;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	private static final int ID_ROL_DEPORTISTA = 1;

	@Override
	public User registrar(User obj) {

		return UsuarioRep.save(obj);
	}

	@Override
	public User modificar(User obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User leerPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean eliminar(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Optional<User> getByNombreUsuario(String nombreUsuario) {
		return UsuarioRep.findByMail(nombreUsuario);
	}

	@Override
	public boolean existsByEmail(String email) {
		return UsuarioRep.existsByMail(email);
	}

	@Override
	@Transactional
	public User crearNuevoUsuario(NewUser nuevoUsuario) {

		User usuario = new User();
		usuario.setMail(nuevoUsuario.getEmail());
		usuario.setName(nuevoUsuario.getNombre());
		usuario.setPassword( passwordEncoder.encode(nuevoUsuario.getPassword()));
		usuario.setPhone(nuevoUsuario.getTelefono());
		User usuarioRegistrado = registrar(usuario);
		UserRole rolUsuario = new UserRole();
		rolUsuario.setUser(usuarioRegistrado);
		rolUsuario.setRole(rolRep.findById(ID_ROL_DEPORTISTA).get());
		UsuarioRolRep.save(rolUsuario);
		return UsuarioRep.findById(usuarioRegistrado.getIdUser()).get();
	}

}
