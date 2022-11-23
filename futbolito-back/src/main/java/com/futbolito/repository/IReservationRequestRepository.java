package com.futbolito.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.models.entities.ReservationRequest;

public interface IReservationRequestRepository extends JpaRepository<ReservationRequest, Long> {

}
