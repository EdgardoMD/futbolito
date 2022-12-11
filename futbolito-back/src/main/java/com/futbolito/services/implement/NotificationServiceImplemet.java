package com.futbolito.services.implement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
		List<NotificationDto>  notificationDtos =    findEntitiesRelatedToNotification(map);
		return notificationDtos;
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
	

	@Async
	private void changeNotificationStatusToSent(List<Notification> notifications) {

		List<Long> idNotificationCreated = new ArrayList<>();
		for (Notification notification : notifications) {
			if (notification.getStatusNotification().getStatusNotification().equals(StatusNotificationEnum.CREATED)) {
				idNotificationCreated.add(notification.getIdNotification());
			}
		}
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
		 
		 List<Notification> notificationsTeamInvitation = new ArrayList<Notification>();
		 List<Notification> notificationsNewTeamChallenge = new ArrayList<Notification>();
		 
		 
		 
		 
		 TypeNotificationEnum typeNotification = null;
		 for(Notification notification: notifications) {
			 typeNotification = notification.getTypeNotification().getTypeNotification();
			 if(typeNotification.equals(TypeNotificationEnum.TEAM_INVITATION)) {
				 notificationsTeamInvitation.add(notification);
			 } else if(typeNotification.equals(TypeNotificationEnum.NEW_CHALLENGE_TEAM)) {
				 notificationsNewTeamChallenge.add(notification);
			 }
			 
		 }
		 
		 
		 
		 
		 map.put(TypeNotificationEnum.TEAM_INVITATION, notificationsTeamInvitation);
		 map.put(TypeNotificationEnum.NEW_CHALLENGE_TEAM, notificationsNewTeamChallenge);
		 
		
		
		
		
		return map;
	}
	
	
	private List<Long> getIdsNotifications(List<Notification> notifications){
		List<Long> idsNotifications = null; 
		if(notifications != null && !notifications.isEmpty() && notifications.size() > 0 ) {
			idsNotifications = new ArrayList<Long>(notifications.size());
			for(Notification notification : notifications) {
				idsNotifications.add(notification.getIdReference());
			}
		}
		return idsNotifications;
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
	
	private Map<Long, Object> searchEntities(List<Long> ids, TypeNotificationEnum typeNotification){
		Map<Long, Object> objects = new HashMap<Long, Object>();
		if(typeNotification.equals(TypeNotificationEnum.TEAM_INVITATION)) {
			List<Invitation> entities =  invitationRepository.findAllById(ids);		
			if(entities != null && !entities.isEmpty()) {
				for(Invitation entitie: entities) {
					objects.put(entitie.getIdInvitation(), (Object) entitie);
				}
			}
		} // en un else if agregar la busqueda de diferentes tipos de notificaciones
		return objects;
	}
	
	
	
	private List<NotificationDto> createDtos(List<Notification> notifications, Map<Long, Object> entities) {
		 List<NotificationDto> notificationDtos = new ArrayList<NotificationDto>();
		 for(Notification notification: notifications) {
			 notificationDtos.add(new NotificationDto(notification, entities.get(notification.getIdReference())));
		 }
		return notificationDtos;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
