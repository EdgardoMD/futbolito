package com.futbolito.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.modelo.entidades.Facility;

public interface IFacilityRepository extends JpaRepository<Facility, Long> {

}
