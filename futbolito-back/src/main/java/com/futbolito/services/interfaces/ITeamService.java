package com.futbolito.services.interfaces;

import java.util.List;

import com.futbolito.models.DTOs.TeamDto;
import com.futbolito.models.DTOs.TeamWihtAthletesDto;
import com.futbolito.models.entities.Athlete;
import com.futbolito.models.entities.Team;

import javassist.NotFoundException;

public interface ITeamService extends ICRUD<Team> {
	
	/**
	 * crea un nuevo equipo, con puntaje cero y lo guarda en bbdd
	 * @param teamDto con el nombre y la ciudad
	 * @return la entidad persistida
	 */
	public TeamDto createNewTeam(TeamDto teamDto, Athlete athlete);
	
	/**
	 * obtiene el listado de equipos asociados al jugador
	 * @return
	 * @throws NotFoundException 
	 */
	public List<TeamDto> getTeamsByIdUser(Long idUser) throws NotFoundException;
	
	/**
	 * obtiene un equupo por id con sus jugadores asociados
	 * @param idTeam
	 * @return
	 */
	public TeamWihtAthletesDto getMyTeamById(Long idTeam);

	
	/**
	 * comprueba que quien hace la peticion pertenece al equipo
	 * @param idUser
	 * @param athletesDtos
	 * @return
	 */
	Boolean belongsToTheTeam(Long idUser, TeamWihtAthletesDto athletesDtos);

}
