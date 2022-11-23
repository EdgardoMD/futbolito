package com.futbolito.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.models.entidades.AtheteTeam;

public interface IAtheteTeamRepository extends JpaRepository<AtheteTeam, Long> {

}
