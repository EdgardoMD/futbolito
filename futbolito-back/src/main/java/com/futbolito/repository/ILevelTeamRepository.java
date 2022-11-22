package com.futbolito.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.modelo.entidades.LevelTeam;

public interface ILevelTeamRepository extends JpaRepository<LevelTeam, Long> {

}
