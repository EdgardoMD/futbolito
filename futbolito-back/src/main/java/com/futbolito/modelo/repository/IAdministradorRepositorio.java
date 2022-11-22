package com.futbolito.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.modelo.entidades.Administrator;

public interface IAdministradorRepositorio extends JpaRepository<Administrator, Long> {

}
