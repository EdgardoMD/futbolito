package com.futbolito.modelo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.modelo.entidades.CalificacionCancha;

public interface ICalificacionCanchaRepositorio extends JpaRepository<CalificacionCancha, Long> {

}
