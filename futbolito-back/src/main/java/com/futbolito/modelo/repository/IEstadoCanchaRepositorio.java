package com.futbolito.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.modelo.entidades.StatusCourt;

public interface IEstadoCanchaRepositorio extends JpaRepository<StatusCourt, Long> {

}
