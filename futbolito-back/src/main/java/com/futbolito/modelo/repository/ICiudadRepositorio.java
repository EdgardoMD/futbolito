package com.futbolito.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.modelo.entidades.City;

public interface ICiudadRepositorio extends JpaRepository<City, Long> {

}
