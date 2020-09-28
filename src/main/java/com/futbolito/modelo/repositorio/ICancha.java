package com.futbolito.modelo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.modelo.entidades.Cancha;

public interface ICancha extends JpaRepository<Cancha, Long> {

}
