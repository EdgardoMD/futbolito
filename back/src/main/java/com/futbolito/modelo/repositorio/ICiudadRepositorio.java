package com.futbolito.modelo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.modelo.entidades.Ciudad;

public interface ICiudadRepositorio extends JpaRepository<Ciudad, Long> {

}
