package com.futbolito.modelo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.modelo.entidades.EquipoDeportista;

public interface IEquipoDeportista extends JpaRepository<EquipoDeportista, Long> {

}
