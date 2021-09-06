package com.futbolito.modelo.repositorio;


import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.modelo.entidades.Rol;

public interface IRolRepositorio extends JpaRepository<Rol, Integer> {
	

}
