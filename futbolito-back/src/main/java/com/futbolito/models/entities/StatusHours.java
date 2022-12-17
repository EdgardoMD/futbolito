package com.futbolito.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Data
@Table(name="status_hours")
public class StatusHours {

	@Id
	@Column(name="id_status_hours")
	private Long id;
	
	@Column(name="status")
	private String status;
	
}
