package com.futbolito.models.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="athletes_sport_type")
public class AthleteSportType {
	
	
	@Id
	@Column(name="id_athlete_Sport_Type")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
	private Long idAthleteSportType;
	
	
	@ManyToOne
	@JoinColumn(name="id_athlete")
	private Athlete athlete;
	
	
	@ManyToOne
	@JoinColumn(name="id_sport_type")
	private SportType sportType;

}
