package com.futbolito.models.DTOs;

import com.futbolito.models.entities.Notification;
import com.futbolito.models.enums.StatusNotificationEnum;
import com.futbolito.models.enums.TypeNotificationEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationDto {
	
	
	private Long idNotification;
	private Long idUser;
	private Long idReference;
	private TypeNotificationEnum typeNotification;
	private StatusNotificationEnum statusNotification;
	public Object data;
	
	public NotificationDto( Notification notification,  Object data){
		this.data = data;
		this.idReference = notification.getIdReference();
		this.idUser = notification.getUser().getIdUser();
		this.idNotification = notification.getIdNotification();
		this.typeNotification = notification.getTypeNotification().getTypeNotification();
		this.statusNotification = notification.getStatusNotification().getStatusNotification();
	}

}
