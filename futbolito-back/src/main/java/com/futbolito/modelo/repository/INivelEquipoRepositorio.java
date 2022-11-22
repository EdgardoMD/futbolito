package com.futbolito.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.modelo.entidades.LevelTeam;

public interface INivelEquipoRepositorio extends JpaRepository<LevelTeam, Long> {

}
