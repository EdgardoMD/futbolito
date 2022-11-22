package com.futbolito.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.modelo.entidades.AthleteMatch;

public interface IDeportistaPartido extends JpaRepository<AthleteMatch, Long> {

}
