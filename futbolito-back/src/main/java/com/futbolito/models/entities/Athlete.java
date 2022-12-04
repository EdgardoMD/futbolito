package com.futbolito.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="athletes")
public class Athlete {
	
	
	@Id
	@Column(name="id_athletes")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
	private Long idAthlete;
	
	@OneToOne
	@JoinColumn(name="id_user")
	private User user;

	@OneToOne
	@JoinColumn(name="athlete_level")
	private LevelAthlete athleteLevel;
	
	@ManyToOne
	@JoinColumn(name="city")
	private City city;
	
	@Column(name="height")
	private float height;
	
	@Column(name="weight")
	private int weight;
	
	@Column(name="position")
	private String position;
	
	@Column(name="skillful_foot")
	private String skillfulFoot;
	
	@Column(name="birth_date")
	private String birthDate;
	
	@Column(name="profile_photo")
	private String profilePhoto;

	public Athlete(User user) {
		this.user = user;
	}
	
	
	
	
	
	
	
}
