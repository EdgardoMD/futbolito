package com.futbolito.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.models.entidades.LevelTeam;

public interface ILevelTeamRepository extends JpaRepository<LevelTeam, Long> {

}
