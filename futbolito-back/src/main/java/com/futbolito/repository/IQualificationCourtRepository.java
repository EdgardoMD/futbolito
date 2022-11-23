package com.futbolito.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.models.entidades.QualificationCourt;

public interface IQualificationCourtRepository extends JpaRepository<QualificationCourt, Long> {

}
