package com.futbolito.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.modelo.entidades.Dispute;

public interface IDisputeRespository extends JpaRepository<Dispute, Long> {

}
