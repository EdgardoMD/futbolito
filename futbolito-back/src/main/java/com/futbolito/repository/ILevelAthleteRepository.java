package com.futbolito.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.modelo.entidades.LevelAthlete;

public interface ILevelAthleteRepository extends JpaRepository<LevelAthlete, Long> {

}
