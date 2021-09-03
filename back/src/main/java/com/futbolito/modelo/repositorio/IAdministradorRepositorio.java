package com.futbolito.modelo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.modelo.entidades.Administrador;

public interface IAdministradorRepositorio extends JpaRepository<Administrador, Long> {

}
