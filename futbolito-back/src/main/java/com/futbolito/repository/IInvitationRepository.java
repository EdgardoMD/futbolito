package com.futbolito.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.futbolito.models.entities.Invitation;

public interface IInvitationRepository extends JpaRepository<Invitation, Long> {

	@Query(value = "select CASE WHEN COUNT(1) > 0 THEN true ELSE false END from invitation "
			+ "where id_status_invitation = (select id_status_invitation  from status_invitation si where status_invitation = 'CREATED') "
			+ "and id_athlete_guest = :id_athlete and id_team = :id_team  ", nativeQuery = true)
	public Boolean thisAthleteIsAGuest(@Param("id_athlete") Long idAthlete, @Param("id_team") Long idTeam);
	
	
	@Query(value = "select * from invitation where id_status_invitation = (select id_status_invitation  from status_invitation si where status_invitation = 'CREATED') "
			+ "and id_athlete_guest = :id_athlete_guest and id_team = :id_team ", nativeQuery = true)
	public Optional<Invitation> findInvitationSendByGuestAndTeam(@Param("id_athlete_guest") Long idAthlete, @Param("id_team") Long idTeam);
	
	
	
	@Modifying(clearAutomatically = true)
	@Query(value = "update invitation "
			+ "set id_status_invitation = (select s_i.id_status_invitation from status_invitation s_i where s_i.status_invitation = :status_invitation) "
			+ "where id_invitation = :id_invitation", nativeQuery = true)
	public void updateInvitaionStatus(@Param("status_invitation") String statusInvitation, @Param("id_invitation") Long idInvitation);

}
