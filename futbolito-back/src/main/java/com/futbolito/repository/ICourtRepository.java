package com.futbolito.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.models.entities.Court;

public interface ICourtRepository extends JpaRepository<Court, Long> {

}
