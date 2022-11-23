package com.futbolito.models.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Data
@Table(name="hours_courts")
public class HourCourt {
	
	@Id
	@Column(name="id_hour_courts")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="id_status_hours")
	private StatusHours statusHours;
	
	@ManyToOne
	@JoinColumn(name="id_hour")
	private Hour hour;
	
	@ManyToOne
	@JoinColumn(name="id_court")
	private Court court;

}
