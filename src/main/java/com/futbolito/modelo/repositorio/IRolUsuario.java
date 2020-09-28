package com.futbolito.modelo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.modelo.entidades.RolUsuario;

public interface IRolUsuario extends JpaRepository<RolUsuario, Integer> {

}
