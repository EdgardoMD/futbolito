package com.futbolito.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.futbolito.models.entities.Notification;

public interface INotificationRepository extends JpaRepository<Notification, Long> {
	
	@Query(value = "select * from notifications where id_user = :id_user", nativeQuery = true)
	List<Notification> findNotificationsbyUserId(@Param("id_user")Long UserId);
	
	
	
	@Modifying(clearAutomatically = true)
	@Query(value = "update notifications "
					+ "	set id_status_notification = (select id_status_notification from status_notification where status_notification = :status) "
					+ "	where id_notification in (:ids_notifications)", nativeQuery = true)
	public void updateStatusNotifictions(String status , @Param("ids_notifications") List<Long> UserId);
	
	

}
