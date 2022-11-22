package com.futbolito.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.modelo.entidades.Match;

public interface IMatchRepository extends JpaRepository<Match, Long> {

}
