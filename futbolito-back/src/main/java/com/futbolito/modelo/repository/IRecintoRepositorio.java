package com.futbolito.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.modelo.entidades.Facility;

public interface IRecintoRepositorio extends JpaRepository<Facility, Long> {

}
