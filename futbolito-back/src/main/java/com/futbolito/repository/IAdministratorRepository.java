package com.futbolito.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.models.entidades.Administrator;

public interface IAdministratorRepository extends JpaRepository<Administrator, Long> {

}
