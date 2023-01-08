package com.futbolito.services.implement;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.futbolito.models.entities.Athlete;
import com.futbolito.models.entities.User;
import com.futbolito.models.entities.UserRole;
import com.futbolito.repository.IAthleteRepository;
import com.futbolito.repository.IRoleRepository;
import com.futbolito.repository.IUserRepository;
import com.futbolito.repository.IUserRoleRepository;
import com.futbolito.security.dto.NewUser;
import com.futbolito.services.interfaces.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserRepository usuarioRep;
	@Autowired
	private IUserRoleRepository UsuarioRolRep;
	@Autowired
	private IRoleRepository rolRep;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private IAthleteRepository athleteRepository;
	
	private static final int ID_ROL_DEPORTISTA = 1; //esto deberiamos cambiarlo, esta muy acoplado al codigo

	@Override
	public User save(User obj) {
		return usuarioRep.save(obj);
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
	public Optional<User> getUserByNickName(String nickName) {
		return usuarioRep.findByNickName(nickName);
	}

	@Override
	public boolean existsByEmail(String email) {
		return usuarioRep.existsByMail(email);
	}

	@Override
	@Transactional
	public User createNewUser(NewUser newUser) {

		User user = new User();
		user.setMail(newUser.getEmail());
		user.setName(newUser.getName());
		user.setPassword( passwordEncoder.encode(newUser.getPassword()));
	//	user.setPhone(newUser.getPhone());
		user.setNickName(newUser.getNickname().toLowerCase().trim());
		user.setCreationDate(LocalDateTime.now());
		User registeredUser = save(user);
		UserRole rolUsuario = new UserRole();
		rolUsuario.setUser(registeredUser);
		rolUsuario.setRole(rolRep.findById(ID_ROL_DEPORTISTA).get());
		UsuarioRolRep.save(rolUsuario);
		Athlete athlete = new Athlete(user);
		athleteRepository.save(athlete);
		return usuarioRep.findById(registeredUser.getIdUser()).get();
	}

	@Override
	public boolean existsByNickName(String nickName) {
		return usuarioRep.existsByNickName(nickName);
	}

}
