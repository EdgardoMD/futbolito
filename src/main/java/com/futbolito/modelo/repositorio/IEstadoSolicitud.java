package com.futbolito.modelo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.modelo.entidades.EstadoSolicitud;

public interface IEstadoSolicitud extends JpaRepository<EstadoSolicitud, Integer> {

}
