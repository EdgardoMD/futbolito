package com.futbolito.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.models.entidades.AthleteComment;

public interface IAthleteCommentRepository extends JpaRepository<AthleteComment, Long> {

}
