package com.futbolito.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.modelo.entidades.AtheteTeam;

public interface IEquipoDeportista extends JpaRepository<AtheteTeam, Long> {

}
