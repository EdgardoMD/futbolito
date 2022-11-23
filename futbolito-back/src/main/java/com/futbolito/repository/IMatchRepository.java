package com.futbolito.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.models.entities.Match;

public interface IMatchRepository extends JpaRepository<Match, Long> {

}
