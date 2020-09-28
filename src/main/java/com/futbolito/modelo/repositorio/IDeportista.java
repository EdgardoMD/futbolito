package com.futbolito.modelo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.modelo.entidades.Deportista;

public interface IDeportista extends JpaRepository<Deportista, Long> {

}
