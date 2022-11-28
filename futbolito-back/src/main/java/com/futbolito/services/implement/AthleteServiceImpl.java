package com.futbolito.services.implement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.futbolito.models.entities.Athlete;
import com.futbolito.models.entities.User;
import com.futbolito.repository.IAthleteRepository;
import com.futbolito.repository.IUserRepository;
import com.futbolito.services.interfaces.IAthleteService;

import javassist.NotFoundException;

@Service
public class AthleteServiceImpl implements IAthleteService {

	@Autowired
	private IAthleteRepository athleteRepository;

	@Autowired
	private IUserRepository userRepository;

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
	public Athlete findAthleteByUserId(Long id) throws NotFoundException {
		Athlete athlete = null;

		Optional<Athlete> athleteOptional = athleteRepository.findByUserId(id);
		if (athleteOptional.isPresent()) {
			athlete = athleteOptional.get();
		} else {
			Optional<User> userOptional = userRepository.findById(id);
			if (userOptional.isPresent()) {
				athlete = new Athlete();
				athlete.setUser(userOptional.get());
			} else {
				throw new NotFoundException("no se encontro usuario con este id");
			}

		}
		return athlete;
	}

}
