package com.futbolito.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.models.entities.QualificationCourt;

public interface IQualificationCourtRepository extends JpaRepository<QualificationCourt, Long> {

}
