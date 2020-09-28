package com.futbolito.modelo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.modelo.entidades.SolicitudReserva;

public interface ISolicitudReserva extends JpaRepository<SolicitudReserva, Long> {

}
