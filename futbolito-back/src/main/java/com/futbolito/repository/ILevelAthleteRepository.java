package com.futbolito.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.models.entidades.LevelAthlete;

public interface ILevelAthleteRepository extends JpaRepository<LevelAthlete, Long> {

}
