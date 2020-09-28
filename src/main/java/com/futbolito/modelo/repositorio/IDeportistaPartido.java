package com.futbolito.modelo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.modelo.entidades.DeportistaPartido;

public interface IDeportistaPartido extends JpaRepository<DeportistaPartido, Long> {

}
