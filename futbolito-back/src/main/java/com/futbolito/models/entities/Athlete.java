package com.futbolito.models.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
	
	@Column(name="creation_date", updatable = false, nullable = false)
	private LocalDateTime creationDate;
	
	@Column(name="update_date")
	private LocalDateTime updateDate;
	
	@ManyToOne
	@JoinColumn(name="gender")
	private Gender gender;
	

	public Athlete(User user) {
		this.user = user;
		this.creationDate =LocalDateTime.now();
		this.idAthlete = user.getIdUser();
	}
	
	
	
	
	
	
	
}
