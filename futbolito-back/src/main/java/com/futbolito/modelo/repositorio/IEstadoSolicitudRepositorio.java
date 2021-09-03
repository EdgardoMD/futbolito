package com.futbolito.modelo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.modelo.entidades.EstadoSolicitudReserva;

public interface IEstadoSolicitudRepositorio extends JpaRepository<EstadoSolicitudReserva, Long> {

}
