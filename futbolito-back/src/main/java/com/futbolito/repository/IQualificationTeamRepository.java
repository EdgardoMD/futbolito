package com.futbolito.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.models.entities.QualificationTeam;

public interface IQualificationTeamRepository extends JpaRepository<QualificationTeam, Long> {

}
