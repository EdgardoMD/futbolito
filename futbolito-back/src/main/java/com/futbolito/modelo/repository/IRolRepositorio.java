package com.futbolito.modelo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.modelo.entidades.Role;

public interface IRolRepositorio extends JpaRepository<Role, Integer> {
	

}
