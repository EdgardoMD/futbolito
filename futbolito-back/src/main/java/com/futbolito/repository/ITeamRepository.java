package com.futbolito.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.futbolito.models.entities.Team;

public interface ITeamRepository extends JpaRepository<Team, Long> {

	@Query(value = "select * from teams t where t.id_teams in (select at. id_team from athletes_teams at where at.id_athlete = (select a.id_athletes from athletes  a where a.id_user = :id_user))", nativeQuery = true)
	List<Team> listTeamsByIdUser(@Param("id_user") Long idUser);

}
