package com.futbolito.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.modelo.entidades.AthleteComment;

public interface IAthleteCommentRepository extends JpaRepository<AthleteComment, Long> {

}
