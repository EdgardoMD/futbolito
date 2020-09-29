package com.futbolito.modelo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.modelo.entidades.EstadoHora;

public interface IEstadoHoraRepositorio extends JpaRepository<EstadoHora, Long> {

}
