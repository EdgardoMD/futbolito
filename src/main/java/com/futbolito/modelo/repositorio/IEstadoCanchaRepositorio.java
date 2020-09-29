package com.futbolito.modelo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.modelo.entidades.EstadoCancha;

public interface IEstadoCanchaRepositorio extends JpaRepository<EstadoCancha, Long> {

}
