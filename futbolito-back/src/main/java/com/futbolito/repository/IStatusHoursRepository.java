package com.futbolito.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.modelo.entidades.StatusHours;

public interface IStatusHoursRepository extends JpaRepository<StatusHours, Long> {

}
