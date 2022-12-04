package com.futbolito.services.interfaces;

import java.util.List;

import com.futbolito.models.DTOs.AthleteDto;
import com.futbolito.models.entities.Athlete;

import javassist.NotFoundException;

public interface IAthleteService extends ICRUD<Athlete> {
	
	public Athlete findAthleteByUserId(Long id) throws NotFoundException;

	/**
	 * busca los jugadores por el inicio de su nick
	 * @param startNick
	 * @return
	 */
	public List<AthleteDto> findAthletesByNickStartswith(String startNick);

}
