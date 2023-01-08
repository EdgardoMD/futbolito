package com.futbolito.services.interfaces;

import java.util.List;

import com.futbolito.models.DTOs.NotificationDto;
import com.futbolito.models.entities.Notification;
import com.futbolito.models.entities.User;
import com.futbolito.models.enums.TypeNotificationEnum;

public interface INotificationService extends ICRUD<Notification> {

	
	/**
	 * busca listado de notificaciones por id de usuario
	 * @param idUser
	 * @return
	 */
	List<NotificationDto> findNotificationByIdUser(Long idUser);

	
	/**
	 * crea notificacion
	 * @param userToNotify
	 * @param idReference
	 * @param typeNotification
	 */
	void createNotification(User userToNotify, Long idReference, TypeNotificationEnum typeNotification);

	/**
	 * crea un listado de notificaciones
	 * @param usersToNotify
	 * @param idReference
	 * @param typeNotification
	 */
	void createListNotifications(List<User> usersToNotify, Long idReference, TypeNotificationEnum typeNotification);



}
