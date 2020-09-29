package com.futbolito.modelo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.modelo.entidades.EstadoSolicitud;

public interface IEstadoSolicitudRepositorio extends JpaRepository<EstadoSolicitud, Long> {

}
