package com.futbolito.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.models.entities.Region;

public interface IRegionRepository extends JpaRepository<Region, Long> {

}
