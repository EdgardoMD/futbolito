package com.futbolito.modelo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.modelo.entidades.EstadoCancha;

public interface IEstadoCancha extends JpaRepository<EstadoCancha, Integer> {

}
