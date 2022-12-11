package com.futbolito.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.futbolito.models.entities.TypeNotification;

public interface ITypeNotificationRepository extends JpaRepository<TypeNotification, Long> {
	
	@Query(value = "select * from notification_types where type_notification = :type ", nativeQuery = true)
	Optional<TypeNotification> findTypeNotificationbyType(String type);

}
