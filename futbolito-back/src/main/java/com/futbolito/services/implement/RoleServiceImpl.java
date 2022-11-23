package com.futbolito.services.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.futbolito.models.entidades.Role;
import com.futbolito.repository.IRoleRepository;
import com.futbolito.services.interfaces.IRoleService;

@Service
public class RoleServiceImpl implements IRoleService {

	@Autowired
	private IRoleRepository roleRepository;

	@Override
	public Role update(Role obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> toList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Role getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public Role save(Role rol) {
		return roleRepository.save(rol);
	}

}
