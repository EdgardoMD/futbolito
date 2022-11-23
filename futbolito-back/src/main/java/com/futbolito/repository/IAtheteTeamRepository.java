package com.futbolito.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.models.entities.AthleteTeam;

public interface IAtheteTeamRepository extends JpaRepository<AthleteTeam, Long> {

}
