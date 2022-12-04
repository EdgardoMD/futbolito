package com.futbolito.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.futbolito.models.entities.StatusInvitation;

public interface IStatusInvitationRepository extends JpaRepository<StatusInvitation, Long>{
	
	@Query(value = "select * from status_invitation where status_invitation = :statusInvitation ", nativeQuery = true)
	Optional<StatusInvitation> findByStatusInvitation(String statusInvitation);

}
