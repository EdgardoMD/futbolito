package com.futbolito.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.models.entities.Hour;

public interface IHourRepository extends JpaRepository<Hour, Long> {

}
