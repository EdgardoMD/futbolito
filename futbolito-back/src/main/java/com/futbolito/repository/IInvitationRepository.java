package com.futbolito.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.futbolito.models.entities.Invitation;

public interface IInvitationRepository extends JpaRepository<Invitation, Long> {

	@Query(value = "select CASE WHEN COUNT(1) > 0 THEN true ELSE false END from invitation where id_athlete_guest = :id_athlete and id_team = :id_team  ", nativeQuery = true)
	public Boolean thisAthleteIsAGuest(@Param("id_athlete") Long idAthlete, @Param("id_team") Long idTeam);

}
