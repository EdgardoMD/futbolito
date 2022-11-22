package com.futbolito.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.modelo.entidades.Athlete;

public interface IDeportistaRepositorio extends JpaRepository<Athlete, Long> {

}
