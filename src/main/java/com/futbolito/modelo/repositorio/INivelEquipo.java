package com.futbolito.modelo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.modelo.entidades.NivelEquipo;

public interface INivelEquipo extends JpaRepository<NivelEquipo, Integer> {

}
