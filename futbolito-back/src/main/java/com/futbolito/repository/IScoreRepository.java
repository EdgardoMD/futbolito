package com.futbolito.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.models.entidades.Score;

public interface IScoreRepository extends JpaRepository<Score, Long> {

}
