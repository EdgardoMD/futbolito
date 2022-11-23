package com.futbolito.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.models.entities.Facility;

public interface IFacilityRepository extends JpaRepository<Facility, Long> {

}
