package com.futbolito.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.models.entidades.Facility;

public interface IFacilityRepository extends JpaRepository<Facility, Long> {

}
