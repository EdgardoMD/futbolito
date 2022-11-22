package com.futbolito.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.modelo.entidades.HoraCancha;

public interface IHoraCancha extends JpaRepository<HoraCancha, Long> {

}
