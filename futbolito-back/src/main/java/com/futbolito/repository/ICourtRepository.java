package com.futbolito.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.models.entidades.Court;

public interface ICourtRepository extends JpaRepository<Court, Long> {

}
