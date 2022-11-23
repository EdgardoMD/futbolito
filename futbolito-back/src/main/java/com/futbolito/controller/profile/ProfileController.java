package com.futbolito.controller.profile;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.futbolito.models.entidades.Athlete;


@CrossOrigin
@RestController
@RequestMapping("profile")
public class ProfileController {
	
	@GetMapping
	public ResponseEntity<Athlete> getProfile(/* Authentication authentication*/){
		
		System.out.println("pide");
		
		Athlete dto = new Athlete();
		dto.setIdAthlete(1l);
		dto.setBirthDate("nacimiento");
		dto.setHeight(1.70f);
		dto.setProfilePhoto("link foto");
		dto.setNick("nickiki");
		
		System.out.println(dto);
		
		return new ResponseEntity<Athlete>(dto, HttpStatus.OK);
	}

}
