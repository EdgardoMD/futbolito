package com.futbolito.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.modelo.entidades.LevelAthlete;

public interface INivelDeportistaRepositorio extends JpaRepository<LevelAthlete, Long> {

}
