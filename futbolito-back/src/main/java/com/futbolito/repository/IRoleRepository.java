package com.futbolito.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.models.entities.Role;

public interface IRoleRepository extends JpaRepository<Role, Integer> {
	

}
