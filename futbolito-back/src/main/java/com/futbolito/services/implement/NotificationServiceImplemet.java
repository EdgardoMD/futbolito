package com.futbolito.services.implement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.futbolito.models.DTOs.NotificationDto;
import com.futbolito.models.entities.Invitation;
import com.futbolito.models.entities.Notification;
import com.futbolito.models.entities.StatusNotification;
import com.futbolito.models.entities.TypeNotification;
import com.futbolito.models.entities.User;
import com.futbolito.models.enums.StatusNotificationEnum;
import com.futbolito.models.enums.TypeNotificationEnum;
import com.futbolito.repository.IInvitationRepository;
import com.futbolito.repository.INotificationRepository;
import com.futbolito.repository.IStatusNotificationRepository;
import com.futbolito.repository.ITypeNotificationRepository;
import com.futbolito.services.interfaces.INotificationService;

@Service
public class NotificationServiceImplemet implements INotificationService {

	@Autowired
	private INotificationRepository notificationRep;

	@Autowired
	private IStatusNotificationRepository statusRep;

	@Autowired
	private ITypeNotificationRepository typeRep;

	@Autowired
	private IInvitationRepository invitationRepository;

	@Override
	public Notification save(Notification notification) {
		return notificationRep.save(notification);
	}

	@Override
	public Notification update(Notification obj) {
		return null;
	}

	@Override
	public List<Notification> toList() {
		return null;
	}

	@Override
	public Notification getById(Long id) {
		return null;
	}

	@Override
	public boolean delete(Long id) {
		return false;
	}

	@Override
	public List<NotificationDto> findNotificationByIdUser(Long idUser) {
		List<Notification> notifications = notificationRep.findNotificationsbyUserId(idUser);
		this.changeNotificationStatusToSent(notifications);
		Map<TypeNotificationEnum, List<Notification>> map = groupNotifications(notifications);
		List<NotificationDto> notificationDtos = findEntitiesRelatedToNotification(map);
		return notificationDtos;
	}

	

	@Async
	private void changeNotificationStatusToSent(List<Notification> notifications) {
		List<Long> idNotificationCreated = notifications.stream()
				.filter(n -> n.getStatusNotification().getStatusNotification().equals(StatusNotificationEnum.CREATED))
				.map(Notification::getIdNotification).collect(Collectors.toList());
		if (idNotificationCreated.size() > 0) {
			this.ChangeStatusNotification(idNotificationCreated, StatusNotificationEnum.SENT);
		}
	}

	private void ChangeStatusNotification(List<Long> idNotificationCreated,
			StatusNotificationEnum statusNotificationEnum) {
		notificationRep.updateStatusNotifictions(statusNotificationEnum.name(), idNotificationCreated);
	}

	private Map<TypeNotificationEnum, List<Notification>> groupNotifications(List<Notification> notifications) {
		Map<TypeNotificationEnum, List<Notification>> map = new HashMap<>();
		for (Notification notification : notifications) {
			TypeNotificationEnum type = notification.getTypeNotification().getTypeNotification();
			if (!map.containsKey(type)) {
				map.put(type, new ArrayList<Notification>());
			}
			map.get(type).add(notification);
		}
		return map;
	}

	private List<NotificationDto> findEntitiesRelatedToNotification(Map<TypeNotificationEnum, List<Notification>> map) {
		List<NotificationDto> notificationDtos = new ArrayList<NotificationDto>();
		for (Entry<TypeNotificationEnum, List<Notification>> notifications : map.entrySet()) {
			List<Notification> notificationsList = notifications.getValue();
			List<Long> idsEntities = getIdsNotifications(notificationsList);
			Map<Long, Object> entities = searchEntities(idsEntities, notifications.getKey());
			notificationDtos.addAll(createDtos(notificationsList, entities));
		}
		return notificationDtos;
	}

	
	
	private Map<Long, Object> searchEntities(List<Long> ids, TypeNotificationEnum typeNotification) {
	    if (typeNotification.equals(TypeNotificationEnum.TEAM_INVITATION)) {
	        List<Invitation> entities = invitationRepository.findAllById(ids);
	        if (entities != null && !entities.isEmpty()) {
	            return entities.stream()
	                           .collect(Collectors.toMap(Invitation::getIdInvitation, invitation -> (Object) invitation));
	        }
	    } // en un else if agregar la busqueda de diferentes tipos de notificaciones
	    return Collections.emptyMap();
	}


	private List<NotificationDto> createDtos(List<Notification> notifications, Map<Long, Object> entities) {
		List<NotificationDto> notificationDtos = new ArrayList<NotificationDto>();
		for (Notification notification : notifications) {
			notificationDtos.add(new NotificationDto(notification, entities.get(notification.getIdReference())));
		}
		return notificationDtos;
	}

	private List<Long> getIdsNotifications(List<Notification> notifications) {

		if (notifications == null || notifications.isEmpty()) {
			return null;
		}
		return notifications.stream().map(notification -> notification.getIdReference()).collect(Collectors.toList());
	}

	
	
	@Async
	@Override
	public void createNotification(User userToNotify, Long idReference, TypeNotificationEnum typeNotification) {
		TypeNotification typeNotifi = typeRep.findTypeNotificationbyType(typeNotification.toString()).orElseThrow();
		StatusNotification statusNotification = statusRep
				.findStatusNotificationbyStatus(StatusNotificationEnum.CREATED.name()).orElseThrow();
		Notification notification = new Notification(userToNotify, statusNotification, typeNotifi, idReference);
		this.save(notification);
	}
}
