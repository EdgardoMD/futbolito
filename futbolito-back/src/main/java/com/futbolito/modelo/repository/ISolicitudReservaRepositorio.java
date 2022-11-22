package com.futbolito.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.modelo.entidades.ReservationRequest;

public interface ISolicitudReservaRepositorio extends JpaRepository<ReservationRequest, Long> {

}
