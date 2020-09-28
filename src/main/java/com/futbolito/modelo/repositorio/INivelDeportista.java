package com.futbolito.modelo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.modelo.entidades.NivelDeportista;

public interface INivelDeportista extends JpaRepository<NivelDeportista, Integer> {

}
