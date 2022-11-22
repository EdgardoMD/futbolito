package com.futbolito.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.modelo.entidades.Dispute;

public interface IDisputaRepositorio extends JpaRepository<Dispute, Long> {

}
