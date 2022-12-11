package com.futbolito.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.models.entities.Invitation;

public interface IInvitationRepository extends JpaRepository<Invitation, Long>{
	

}
