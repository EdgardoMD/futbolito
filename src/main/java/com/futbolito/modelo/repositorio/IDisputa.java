package com.futbolito.modelo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.modelo.entidades.Disputa;

public interface IDisputa extends JpaRepository<Disputa, Long> {

}
