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
@Table(name="athletes_teams")
public class AthleteTeam {
	
	@Id
	@Column(name="id_athlete_team")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
	private Long idAthleteTeam;
	
	@ManyToOne
	@JoinColumn(name="id_team")
	private Team team;
	
	@ManyToOne
	@JoinColumn(name="id_athlete")
	private Athlete athlete;

	public AthleteTeam(Team team, Athlete athlete) {
		this.team = team;
		this.athlete = athlete;
	}
	


}
