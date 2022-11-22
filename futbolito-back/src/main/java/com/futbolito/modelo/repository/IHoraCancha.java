package com.futbolito.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.modelo.entidades.HourCourt;

public interface IHoraCancha extends JpaRepository<HourCourt, Long> {

}
