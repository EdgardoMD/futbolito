package com.futbolito.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.models.entidades.AthleteMatch;

public interface IAthleteMatchRepository extends JpaRepository<AthleteMatch, Long> {

}
