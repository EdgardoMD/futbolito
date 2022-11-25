package com.futbolito.services.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.futbolito.models.entities.Athlete;
import com.futbolito.repository.IAthleteRepository;
import com.futbolito.services.interfaces.IAthleteService;

@Service
public class AthleteServiceImpl implements IAthleteService {
	
	@Autowired
	private IAthleteRepository athleteRepository;
	
	

	@Override
	public Athlete save(Athlete obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Athlete update(Athlete obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Athlete> toList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Athlete getById(Long id) {
		Athlete athlete = athleteRepository.findById(id).orElseThrow();
		return athlete;
	}

	@Override
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Athlete findAthleteByUserId(Long id) {
		Athlete athlete = athleteRepository.findByUserId(id).orElseThrow();
		return athlete;
	}

}
