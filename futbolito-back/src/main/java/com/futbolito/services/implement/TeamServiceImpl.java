package com.futbolito.services.implement;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.futbolito.models.DTOs.AthleteDto;
import com.futbolito.models.DTOs.TeamDto;
import com.futbolito.models.DTOs.TeamWihtAthletesDto;
import com.futbolito.models.entities.Athlete;
import com.futbolito.models.entities.AthleteTeam;
import com.futbolito.models.entities.City;
import com.futbolito.models.entities.Invitation;
import com.futbolito.models.entities.LevelTeam;
import com.futbolito.models.entities.Team;
import com.futbolito.repository.IAtheteTeamRepository;
import com.futbolito.repository.ICityRepository;
import com.futbolito.repository.ILevelTeamRepository;
import com.futbolito.repository.ITeamRepository;
import com.futbolito.services.interfaces.IInvitationService;
import com.futbolito.services.interfaces.ITeamService;

import javassist.NotFoundException;

@Service
public class TeamServiceImpl implements ITeamService {

	@Autowired
	private ITeamRepository teamRepository;

	@Autowired
	private ICityRepository cityRepository;

	@Autowired
	private ILevelTeamRepository levelTeamRepository;
	
	@Autowired
	private IAtheteTeamRepository atheteTeamRepository;

	
	@Autowired
	private IInvitationService invitationService;

	@Override
	public Team save(Team obj) {
		return null;
	}

	@Override
	public Team update(Team obj) {
		return null;
	}

	@Override
	public List<Team> toList() {
		return null;
	}

	@Override
	public Team getById(Long id) {
		try {
			return teamRepository.findById(id).orElseThrow(() -> new Exception("No se encontró el equipo id = " + id));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean delete(Long id) {
		return false;
	}



	@Override
	@Transactional
	public TeamDto createNewTeam(TeamDto teamDto, Athlete athlete) {
		try {

			Team team = new Team();
			City city = cityRepository.findById(teamDto.getIdCity())
					.orElseThrow(() -> new Exception("No se encontró el la ciudad"));
			LevelTeam levelTeam = levelTeamRepository.findById(1L)
					.orElseThrow(() -> new Exception("No se encontró el nivel de atleta"));

			team.setName(teamDto.getName());

			team.setTeamLevel(levelTeam);
			team.setCity(city);
			team.setScore(0);
			team.setCreationDate(LocalDateTime.now());
			Team teamSaved = teamRepository.save(team);
			AthleteTeam athleteTeam = new AthleteTeam();
			athleteTeam.setAthlete(athlete);
			athleteTeam.setTeam(teamSaved);
			athleteTeam.setIsCaptain(true);
			athleteTeam.setCreationDate(LocalDateTime.now());
			atheteTeamRepository.save(athleteTeam);
			TeamDto teamDtoSaved = new TeamDto(teamSaved);
			return teamDtoSaved;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<TeamDto> getTeamsByIdUser(Long idUser) throws NotFoundException {
		List<Team> teams =  teamRepository.listTeamsByIdUser(idUser) ;
		List<TeamDto> teamDtos;
		if(teams != null) {
			teamDtos = new ArrayList<>(teams.size());
			for(Team team: teams) {
				teamDtos.add(new TeamDto(team));
			}
		} else {
			throw new NotFoundException("no se encontraron equipos asociados a este athleta");
		}
		return teamDtos;
	}

	@Override
	public TeamWihtAthletesDto getMyTeamById(Long idTeam, Long idUser) {
		Team team = this.getById(idTeam);
		List<AthleteTeam> athleteTeams = team.getAthletesTeam();
		List<Invitation> invitationsToTeam = team.getInvitationToTeam();
		TeamDto teamDto = new TeamDto(team);
		
		List<AthleteDto> athleteOfTeamDtos = null;
		if (athleteTeams != null && !athleteTeams.isEmpty()) {
		    athleteOfTeamDtos = athleteTeams.stream()
		        .map(AthleteTeam::getAthlete)
		        .map(AthleteDto::new).collect(Collectors.toList());
		}

		List<AthleteDto> athleteGuestDtos = null;
		if (invitationsToTeam != null && !invitationsToTeam.isEmpty()) {
		    athleteGuestDtos = invitationsToTeam.stream()
		        .map(Invitation::getAthleteGuest)
		        .map(AthleteDto::new).collect(Collectors.toList());
		}
		
		TeamWihtAthletesDto teamWhitAthletesDto = new TeamWihtAthletesDto(teamDto, athleteOfTeamDtos, athleteGuestDtos);
		teamWhitAthletesDto.getTeamDto().setIsMyTeam(belongsToTheTeam(idUser, teamWhitAthletesDto));
		teamWhitAthletesDto.getTeamDto().setIsGuest(invitationService.thisAthleteIsAGuest(idUser, idTeam));
		return teamWhitAthletesDto;
	}
	
	@Override
	public Boolean belongsToTheTeam(Long idUser, TeamWihtAthletesDto athletesDtos) {
		List<AthleteDto> athletes = athletesDtos.getAthletesOfTeam();
		for (AthleteDto athlete: athletes) {
			if(athlete.getIdUser().longValue() == idUser.longValue()) {
				return true;
			}
		}
		return false;
	}
	
	
	

	


}
