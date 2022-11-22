package com.futbolito.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.modelo.entidades.StatusHours;

public interface IEstadoHoraRepositorio extends JpaRepository<StatusHours, Long> {

}
