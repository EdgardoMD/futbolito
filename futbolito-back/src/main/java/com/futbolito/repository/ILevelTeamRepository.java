package com.futbolito.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.models.entities.LevelTeam;

public interface ILevelTeamRepository extends JpaRepository<LevelTeam, Long> {

}
