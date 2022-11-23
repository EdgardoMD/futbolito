package com.futbolito.services.implement;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.futbolito.models.entities.User;
import com.futbolito.models.entities.UserRole;
import com.futbolito.repository.IRoleRepository;
import com.futbolito.repository.IUserRepository;
import com.futbolito.repository.IUserRoleRepository;
import com.futbolito.security.dto.NewUser;
import com.futbolito.services.interfaces.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserRepository UsuarioRep;
	@Autowired
	private IUserRoleRepository UsuarioRolRep;
	@Autowired
	private IRoleRepository rolRep;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	private static final int ID_ROL_DEPORTISTA = 1; //esto deberiamos cambiarlo, esta muy acoplado al codigo

	@Override
	public User save(User obj) {
		return UsuarioRep.save(obj);
	}

	@Override
	public User update(User obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> toList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Optional<User> getUserByUserName(String nombreUsuario) {
		return UsuarioRep.findByMail(nombreUsuario);
	}

	@Override
	public boolean existsByEmail(String email) {
		return UsuarioRep.existsByMail(email);
	}

	@Override
	@Transactional
	public User createNewUser(NewUser nuevoUsuario) {

		User user = new User();
		user.setMail(nuevoUsuario.getEmail());
		user.setName(nuevoUsuario.getName());
		user.setPassword( passwordEncoder.encode(nuevoUsuario.getPassword()));
		user.setPhone(nuevoUsuario.getPhone());
		User registeredUser = save(user);
		UserRole rolUsuario = new UserRole();
		rolUsuario.setUser(registeredUser);
		rolUsuario.setRole(rolRep.findById(ID_ROL_DEPORTISTA).get());
		UsuarioRolRep.save(rolUsuario);
		return UsuarioRep.findById(registeredUser.getIdUser()).get();
	}

}
