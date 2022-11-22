package com.futbolito.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.modelo.entidades.Team;

public interface ITeamRepository extends JpaRepository<Team, Long> {

}
