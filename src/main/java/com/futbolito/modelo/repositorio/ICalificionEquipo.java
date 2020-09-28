package com.futbolito.modelo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.modelo.entidades.CalificacionEquipo;

public interface ICalificionEquipo extends JpaRepository<CalificacionEquipo, Long> {

}
