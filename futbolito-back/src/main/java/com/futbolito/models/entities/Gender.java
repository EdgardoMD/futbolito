package com.futbolito.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import com.futbolito.models.enums.GenderEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="genders")
public class Gender {
	
	@Id
	@Column(name="id_genders")
	private Long idGender;
	
	@Column(name="gender")
	@Enumerated(EnumType.STRING)
	private GenderEnum Gender;
	
	@Column(name="is_gender_team")
	private boolean isGenderTeam;
	
	@Column(name="is_gender_athlete")
	private boolean isGenderAthlete;

}
