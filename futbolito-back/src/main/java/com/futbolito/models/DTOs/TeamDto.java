package com.futbolito.models.DTOs;

import java.util.List;

import com.futbolito.models.entities.Team;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamDto {

	private Long id;
	private String teamLevel;
	private Long idTeamLevel;
	private int score;
	private String name;
	private String city;
	private Long idCity;
	private List<Long> idsAtletes;
	private Boolean isMyTeam;
	private Boolean isGuest;
	
	public TeamDto(Team team) {
		this.id = team.getId()  ;
		this.teamLevel = team.getTeamLevel().getLevel()  ;
		this.idTeamLevel = team.getTeamLevel().getId()  ;
		this.score = team.getScore()  ;
		this.name = team.getName()  ;
		this.city = team.getCity().getCity()  ;
		this.idCity = team.getCity().getIdCity()  ;
	}
	
	
	
}
