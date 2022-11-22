package com.futbolito.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.modelo.entidades.Match;

public interface IPartidoRepositorio extends JpaRepository<Match, Long> {

}
