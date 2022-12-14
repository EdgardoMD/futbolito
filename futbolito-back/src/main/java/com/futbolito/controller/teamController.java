package com.futbolito.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.futbolito.models.DTOs.TeamDto;
import com.futbolito.models.DTOs.TeamWihtAthletesDto;
import com.futbolito.models.entities.Athlete;
import com.futbolito.security.entity.MainUser;
import com.futbolito.services.interfaces.IAthleteService;
import com.futbolito.services.interfaces.ITeamService;

import javassist.NotFoundException;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("team")
public class teamController {
	
	@Autowired
	private ITeamService teamService;
	
	@Autowired
	private IAthleteService athleteService;
	
	@PostMapping("/new-team")
	public ResponseEntity<TeamDto> newTeam(@RequestBody TeamDto teamDto , Authentication authentication){
		Long idUser = ((MainUser) authentication.getPrincipal()).getId();
		try {
			Athlete athlete = athleteService.findAthleteByUserId(idUser);
			TeamDto team = teamService.createNewTeam(teamDto, athlete);
			return new ResponseEntity<TeamDto>(team, HttpStatus.OK);
		} catch (NotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
		}
		
	}
	
	@GetMapping("/my-teams")
	public ResponseEntity<List<TeamDto>> getListMyTeams( Authentication authentication){
		Long idUser = ((MainUser) authentication.getPrincipal()).getId();
		try {
			List<TeamDto> teamDtos = teamService.getTeamsByIdUser(idUser);
			return new ResponseEntity<List<TeamDto>>(teamDtos, HttpStatus.OK);
		} catch (NotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}
	
	@GetMapping("/my-team")
	public ResponseEntity<TeamWihtAthletesDto> getMyTeam(@RequestParam Long idTeam,  Authentication authentication){
		Long idUser = ((MainUser) authentication.getPrincipal()).getId();
		try {
			TeamWihtAthletesDto athletesDtos = teamService.getMyTeamById(idTeam, idUser);
			if(teamService.belongsToTheTeam(idUser, athletesDtos)) {
				return new ResponseEntity<TeamWihtAthletesDto>(athletesDtos, HttpStatus.OK);
			} else {
				throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}
	
	@GetMapping("/team")
	public ResponseEntity<TeamWihtAthletesDto> getTeam(@RequestParam Long idTeam,  Authentication authentication){
		Long idUser = ((MainUser) authentication.getPrincipal()).getId();
		try {
			TeamWihtAthletesDto athletesDtos = teamService.getMyTeamById(idTeam, idUser);
			return new ResponseEntity<TeamWihtAthletesDto>(athletesDtos, HttpStatus.OK);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}
	
	

}
