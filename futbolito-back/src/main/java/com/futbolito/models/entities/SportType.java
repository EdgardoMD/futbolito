package com.futbolito.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import com.futbolito.models.enums.SportTypeEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="sports_types")
public class SportType {
	
	@Id
	@Column(name="id_sport_type")
	private Long idSportType;
	
	@Column(name="sport_type")
	@Enumerated(EnumType.STRING)
	private SportTypeEnum sportType;
	
	@Column(name="is_team_sport")
	private boolean isTeamSport;

}
