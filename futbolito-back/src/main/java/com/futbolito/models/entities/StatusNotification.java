package com.futbolito.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import com.futbolito.models.enums.StatusNotificationEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="status_notification")
public class StatusNotification {
	
	@Id
	@Column(name="id_status_notification")
	private Long idTypeNotification;

	
	@Column(name="status_notification")
	@Enumerated(EnumType.STRING)
	private StatusNotificationEnum statusNotification;

}
