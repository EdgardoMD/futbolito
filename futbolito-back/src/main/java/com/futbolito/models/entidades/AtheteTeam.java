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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="athetes_teams")
public class AtheteTeam {
	
	@Id
	@Column(name="id_athete_team")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
	private Long idAtheteTeam;
	
	@ManyToOne
	@JoinColumn(name="id_team")
	private Team team;
	
	@ManyToOne
	@JoinColumn(name="id_athlete")
	private Athlete athlete;

}
