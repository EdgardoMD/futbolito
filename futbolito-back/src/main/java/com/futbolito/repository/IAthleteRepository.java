package com.futbolito.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.futbolito.models.entities.Athlete;

public interface IAthleteRepository extends JpaRepository<Athlete, Long> {

	@Query(value = "select * from athletes where id_user = :id_user", nativeQuery = true)
	Optional<Athlete> findByUserId(@Param("id_user") Long idUser);

	@Query(value = "select * from athletes a where id_athletes in (select a_t.id_athlete from athletes_teams a_t where a_t.id_team = :id_team)", nativeQuery = true)
	List<Athlete> getAthletesByIdTeams(@Param("id_team") Long idTeam);
	
	@Query(value = "select * from athletes a where id_user in (select id_user from users where LOWER(nick_name) LIKE LOWER(:nick) || '%' limit 10)", nativeQuery = true)
	List<Athlete> findAthletesByNickStartswith(@Param("nick") String startNick);

}
