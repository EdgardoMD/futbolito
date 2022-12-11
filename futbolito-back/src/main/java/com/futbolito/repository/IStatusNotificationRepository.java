package com.futbolito.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.futbolito.models.entities.StatusNotification;

public interface IStatusNotificationRepository extends JpaRepository<StatusNotification, Long> {
	
	@Query(value = "select * from status_notification where status_notification  = :status", nativeQuery = true)
	Optional<StatusNotification> findStatusNotificationbyStatus(String status);

}
