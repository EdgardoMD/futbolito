package com.futbolito.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.modelo.entidades.StatusReservationRequest;

public interface IEstadoSolicitudRepositorio extends JpaRepository<StatusReservationRequest, Long> {

}
