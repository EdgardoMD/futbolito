package com.futbolito.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.futbolito.models.DTOs.NotificationDto;
import com.futbolito.security.entity.MainUser;
import com.futbolito.services.interfaces.INotificationService;

@RestController
@RequestMapping("notifications")
public class NotificationController {
	
	@Autowired
	private INotificationService notificationService;
	
	
	
	@GetMapping()
	public ResponseEntity<List<NotificationDto>> findNotification( Authentication authentication){
		Long idUser = ((MainUser) authentication.getPrincipal()).getId();
		try {
			List<NotificationDto> teamDtos = notificationService.findNotificationByIdUser(idUser);
			return new ResponseEntity<List<NotificationDto>>(teamDtos, HttpStatus.OK);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}

}
