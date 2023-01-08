package com.futbolito.models.entities;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="teams")
public class Team {
	
	@Id
	@Column(name="id_teams")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="id_team_level")
	private LevelTeam teamLevel;
	
	@Column(name="score")
	private int score;

	@Column(name="name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name="id_city")
	private City city;
	
	@JsonIgnore
	@OneToMany(mappedBy="team")
	@Fetch(FetchMode.JOIN)
	private List<AthleteTeam> athletesTeam;
	
	@JsonIgnore
	@OneToMany(mappedBy="team")
	//@Fetch(FetchMode.JOIN)
	private List<Invitation> invitationToTeam;
	
	@Column(name="creation_date", updatable = false, nullable = false)
	private LocalDateTime creationDate;
	
	@Column(name="update_date")
	private LocalDateTime updateDate;

}
