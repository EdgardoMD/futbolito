package com.futbolito.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.models.entities.AthleteComment;

public interface IAthleteCommentRepository extends JpaRepository<AthleteComment, Long> {

}
