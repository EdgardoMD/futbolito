package com.futbolito.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.futbolito.models.entities.Team;

public interface ITeamRepository extends JpaRepository<Team, Long> {

	@Query(value = "select * from teams where id_teams in (select id_teams from athletes_teams where id_athlete = (select id_athletes  from athletes where id_user = :id_user))", nativeQuery = true)
	List<Team> listTeamsByIdUser(@Param("id_user") Long idUser);

}
