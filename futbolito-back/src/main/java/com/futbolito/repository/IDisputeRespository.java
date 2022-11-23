package com.futbolito.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.models.entities.Dispute;

public interface IDisputeRespository extends JpaRepository<Dispute, Long> {

}
