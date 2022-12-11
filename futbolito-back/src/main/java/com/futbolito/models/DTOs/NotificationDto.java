package com.futbolito.models.DTOs;

import com.futbolito.models.entities.Notification;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationDto {
	
	public Notification notification;
	public Object data;

}
