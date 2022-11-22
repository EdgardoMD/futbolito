package com.futbolito.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.modelo.entidades.Athlete;

public interface IAthleteRepository extends JpaRepository<Athlete, Long> {

}
