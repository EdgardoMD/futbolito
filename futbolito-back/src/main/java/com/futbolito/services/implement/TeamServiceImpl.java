package com.futbolito.services.implement;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.futbolito.models.DTOs.AthleteDto;
import com.futbolito.models.DTOs.TeamDto;
import com.futbolito.models.DTOs.TeamWihtAthletesDto;
import com.futbolito.models.entities.Athlete;
import com.futbolito.models.entities.AthleteTeam;
import com.futbolito.models.entities.City;
import com.futbolito.models.entities.LevelTeam;
import com.futbolito.models.entities.Team;
import com.futbolito.repository.IAtheteTeamRepository;
import com.futbolito.repository.IAthleteRepository;
import com.futbolito.repository.ICityRepository;
import com.futbolito.repository.ILevelTeamRepository;
import com.futbolito.repository.ITeamRepository;
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
	private IAthleteRepository athleteRepository;

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
		return teamRepository.findById(id).orElseThrow();
	}

	@Override
	public boolean delete(Long id) {
		return false;
	}



	@Override
	@Transactional
	public TeamDto createNewTeam(TeamDto teamDto, Athlete athlete) {
		Team team = new Team();
		City city = cityRepository.findById(teamDto.getIdCity()).orElseThrow();
		LevelTeam levelTeam = levelTeamRepository.findById(1L).orElseThrow();
		team.setName(teamDto.getName());
		team.setTeamLevel(levelTeam);
		team.setCity(city);
		team.setScore(0);
		Team teamSaved = teamRepository.save(team);
		AthleteTeam athleteTeam = new AthleteTeam();
		athleteTeam.setAthlete(athlete);
		athleteTeam.setTeam(teamSaved);
		atheteTeamRepository.save(athleteTeam);
		TeamDto teamDtoSaved = new TeamDto(teamSaved);
		return teamDtoSaved;
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
	public TeamWihtAthletesDto getMyTeamById(Long idTeam) {
		Team team = this.getById(idTeam);
		List<Athlete> athletes = athleteRepository.getAthletesByIdTeams(idTeam);
		TeamDto teamDto = new TeamDto(team);
		List<AthleteDto> athleteDtos;
		TeamWihtAthletesDto teamWhitAthletesDto;
		if(athletes!= null && !athletes.isEmpty()) {
			athleteDtos = new ArrayList<>(athletes.size());
			for(Athlete athlete :athletes) {
				athleteDtos.add(new AthleteDto(athlete));
			}
			teamWhitAthletesDto = new TeamWihtAthletesDto(teamDto, athleteDtos);
		} else {
			teamWhitAthletesDto = new TeamWihtAthletesDto(teamDto);
		}
		return teamWhitAthletesDto;
	}
	
	@Override
	public Boolean belongsToTheTeam(Long idUser, TeamWihtAthletesDto athletesDtos) {
		List<AthleteDto> athletes = athletesDtos.getAthleteDto();
		for (AthleteDto athlete: athletes) {
			if(athlete.getIdUser() == idUser) {
				return true;
			}
		}
		return false;
	}
	


}
