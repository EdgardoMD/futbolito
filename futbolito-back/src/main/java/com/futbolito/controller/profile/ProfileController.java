package com.futbolito.controller.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.futbolito.models.DTOs.AthleteDto;
import com.futbolito.models.entities.Athlete;
import com.futbolito.security.entity.MainUser;
import com.futbolito.services.interfaces.IAthleteService;

@CrossOrigin
@RestController
@RequestMapping("profile")
public class ProfileController {

	@Autowired
	private IAthleteService athleteService;

	@GetMapping("/athlete")
	public ResponseEntity<AthleteDto> getProfile(Authentication authentication) {
		try {
			Long idUser = ((MainUser) authentication.getPrincipal()).getId();
			Athlete athlete = athleteService.findAthleteByUserId(idUser);
			return new ResponseEntity<AthleteDto>(new AthleteDto(athlete), HttpStatus.OK);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
		}

	}

}
