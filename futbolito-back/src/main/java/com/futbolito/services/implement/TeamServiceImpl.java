package com.futbolito.services.implement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.futbolito.models.DTOs.TeamDto;
import com.futbolito.models.entities.Athlete;
import com.futbolito.models.entities.AthleteTeam;
import com.futbolito.models.entities.City;
import com.futbolito.models.entities.LevelTeam;
import com.futbolito.models.entities.Team;
import com.futbolito.repository.IAtheteTeamRepository;
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

	@Override
	public Team save(Team obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Team update(Team obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Team> toList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Team getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
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
		List<TeamDto> teamDtos = new ArrayList<>();
		if(teams != null) {
			for(Team team: teams) {
				teamDtos.add(new TeamDto(team));
			}
		} else {
			throw new NotFoundException("no se encontraron equipos asociados a este athleta");
		}
		return teamDtos;
	}
	


}
