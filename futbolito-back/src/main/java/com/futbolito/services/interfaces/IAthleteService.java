package com.futbolito.services.interfaces;

import com.futbolito.models.entities.Athlete;

import javassist.NotFoundException;

public interface IAthleteService extends ICRUD<Athlete> {
	
	public Athlete findAthleteByUserId(Long id) throws NotFoundException;

}
