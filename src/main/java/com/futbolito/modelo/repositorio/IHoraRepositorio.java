package com.futbolito.modelo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.modelo.entidades.Hora;

public interface IHoraRepositorio extends JpaRepository<Hora, Long> {

}
