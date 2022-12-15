package com.futbolito.models.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="notifications")
public class Notification {
	
	@Id
	@Column(name="id_notification")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
	private Long idNotification;
	
	@OneToOne
	@JoinColumn(name="id_user")
	private User user;
	
	@OneToOne
	@JoinColumn(name="id_status_Notification")
	private StatusNotification statusNotification;
	
	@OneToOne
	@JoinColumn(name="id_type_Notification")
	private TypeNotification typeNotification;
	
	@Column(name="id_reference")
	private Long idReference;
	
	@Column(name="creation_date", updatable = false, nullable = false)
	private LocalDateTime creationDate;
	
	@Column(name="update_date")
	private LocalDateTime updateDate;

	public Notification(User user, StatusNotification statusNotification, TypeNotification typeNotification,
			Long idReference, LocalDateTime creationDate ) {
		this.user = user;
		this.statusNotification = statusNotification;
		this.typeNotification = typeNotification;
		this.idReference = idReference;
		this.creationDate = creationDate;
	}
	
	
	
	
	
	
	

}
