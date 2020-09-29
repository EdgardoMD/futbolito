package com.futbolito.modelo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.modelo.entidades.Disputa;

public interface IDisputaRepositorio extends JpaRepository<Disputa, Long> {

}
