package com.futbolito.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.models.entidades.City;

public interface ICityRepository extends JpaRepository<City, Long> {

}
