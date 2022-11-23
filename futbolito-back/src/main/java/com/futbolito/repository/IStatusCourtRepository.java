package com.futbolito.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.models.entidades.StatusCourt;

public interface IStatusCourtRepository extends JpaRepository<StatusCourt, Long> {

}
