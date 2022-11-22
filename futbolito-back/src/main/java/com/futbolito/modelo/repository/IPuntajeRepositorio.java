package com.futbolito.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.modelo.entidades.Score;

public interface IPuntajeRepositorio extends JpaRepository<Score, Long> {

}
