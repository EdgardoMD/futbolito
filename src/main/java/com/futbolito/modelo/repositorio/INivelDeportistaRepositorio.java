package com.futbolito.modelo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.modelo.entidades.NivelDeportista;

public interface INivelDeportistaRepositorio extends JpaRepository<NivelDeportista, Long> {

}
