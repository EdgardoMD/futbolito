package com.futbolito.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.models.entidades.Team;

public interface ITeamRepository extends JpaRepository<Team, Long> {

}
