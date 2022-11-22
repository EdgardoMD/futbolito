package com.futbolito.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.modelo.entidades.AthleteComment;

public interface IComentarioDeportistaRepositorio extends JpaRepository<AthleteComment, Long> {

}
