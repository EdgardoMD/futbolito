package com.futbolito.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.models.entidades.HourCourt;

public interface IHourCourtRepository extends JpaRepository<HourCourt, Long> {

}
