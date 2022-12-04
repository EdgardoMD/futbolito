package com.futbolito.models.DTOs;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamWihtAthletesDto {
	
	private TeamDto teamDto;
	private List<AthleteDto> athletesDto ;
	
	public TeamWihtAthletesDto(TeamDto teamDto){
		this.teamDto = teamDto;
	}

}
