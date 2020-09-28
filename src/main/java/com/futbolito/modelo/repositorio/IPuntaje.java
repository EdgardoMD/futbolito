package com.futbolito.modelo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.modelo.entidades.Puntaje;

public interface IPuntaje extends JpaRepository<Puntaje, Long> {

}
