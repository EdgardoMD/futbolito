package com.futbolito.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.modelo.entidades.ComentarioDeportista;

public interface IComentarioDeportistaRepositorio extends JpaRepository<ComentarioDeportista, Long> {

}
