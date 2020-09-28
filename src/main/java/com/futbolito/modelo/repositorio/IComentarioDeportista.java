package com.futbolito.modelo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.modelo.entidades.ComentarioDeportista;

public interface IComentarioDeportista extends JpaRepository<ComentarioDeportista, Long> {

}
