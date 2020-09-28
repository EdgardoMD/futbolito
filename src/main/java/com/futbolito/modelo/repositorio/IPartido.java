package com.futbolito.modelo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.modelo.entidades.Partido;

public interface IPartido extends JpaRepository<Partido, Long> {

}
