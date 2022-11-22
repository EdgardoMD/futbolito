package com.futbolito.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.modelo.entidades.Team;

public interface IEquipoRepositorio extends JpaRepository<Team, Long> {

}
