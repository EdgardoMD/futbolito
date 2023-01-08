package com.futbolito.services.implement;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	Logger logger = Logger.getLogger(NotificationServiceImplemet.class.getName());

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
	
	public List<Notification> saveAll(List<Notification> notifications) {
		return notificationRep.saveAll(notifications);
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
	@Transactional
	public List<NotificationDto> findNotificationByIdUser(Long idUser) {
		try {
			List<Notification> notifications = notificationRep.findNotificationsbyUserId(idUser);
			this.changeNotificationStatusToSent(notifications);
			Map<TypeNotificationEnum, List<Notification>> map = groupNotifications(notifications);
			List<NotificationDto> notificationDtos = findEntitiesRelatedToNotification(map);
			return notificationDtos;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
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

	@Async

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
		TypeNotificationEnum TEAM_INVITATION = TypeNotificationEnum.TEAM_INVITATION;
		TypeNotificationEnum NEW_MEMBER_TEAM = TypeNotificationEnum.NEW_MEMBER_TEAM;
		TypeNotificationEnum INVITATION_ACCEPTED = TypeNotificationEnum.INVITATION_ACCEPTED;  	
		TypeNotificationEnum INVITATION_REJECTION = TypeNotificationEnum.INVITATION_REJECTION;
		
		
	    if (typeNotification.equals(TEAM_INVITATION) || typeNotification.equals(NEW_MEMBER_TEAM) ||
	    		typeNotification.equals(INVITATION_ACCEPTED) || typeNotification.equals(INVITATION_REJECTION)) {
	        List<Invitation> entities = invitationRepository.findAllById(ids);
	        if (entities != null && !entities.isEmpty()) {
	            return entities.stream()
	                           .collect(Collectors.toMap(Invitation::getIdInvitation, invitation -> (Object) invitation));
	        }
	    } 
	    // en un else if agregar la busqueda de diferentes tipos de notificaciones
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
		TypeNotification typeNotifi;
		try {
			typeNotifi = typeRep.findTypeNotificationbyType(typeNotification.toString()).orElseThrow(() -> new Exception("No se encontró el tipo de notificacion = " + typeNotification.name()));
		
		StatusNotification statusNotification = statusRep
				.findStatusNotificationbyStatus(StatusNotificationEnum.CREATED.name()).orElseThrow(() -> new Exception("No se encontró el estado de notificacion = CREATED"));
		Notification notification = new Notification(userToNotify, statusNotification, typeNotifi, idReference,
				LocalDateTime.now());
		this.save(notification);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Async
	@Override
	public void createListNotifications(List<User> usersToNotify, Long idReference, TypeNotificationEnum typeNotification) {
		try {
			TypeNotification typeNotifi = typeRep.findTypeNotificationbyType(typeNotification.toString()).orElseThrow(() -> new Exception("no se encontro el tipo de notificacion"));
			StatusNotification statusNotification = statusRep
					.findStatusNotificationbyStatus(StatusNotificationEnum.CREATED.name()).orElseThrow(() -> new Exception("No se encontró el estado de notificacion = CREATED"));
			List<Notification> notifications = usersToNotify.stream().map(userToNotify -> 
					new Notification(userToNotify, statusNotification, typeNotifi, idReference, LocalDateTime.now()))
					.collect(Collectors.toList());
			this.saveAll(notifications);
		} catch (Exception e) {
			logger.severe(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
