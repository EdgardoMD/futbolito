package com.futbolito.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.modelo.entidades.Hour;

public interface IHoraRepositorio extends JpaRepository<Hour, Long> {

}
