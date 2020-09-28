package com.futbolito.modelo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.modelo.entidades.Equipo;

public interface IEquipo extends JpaRepository<Equipo, Long> {

}
