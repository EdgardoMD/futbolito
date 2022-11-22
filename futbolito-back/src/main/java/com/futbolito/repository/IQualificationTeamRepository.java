package com.futbolito.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.modelo.entidades.QualificationTeam;

public interface IQualificationTeamRepository extends JpaRepository<QualificationTeam, Long> {

}
