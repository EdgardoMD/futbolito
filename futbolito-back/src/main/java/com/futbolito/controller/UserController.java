package com.futbolito.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.futbolito.models.DTOs.TeamWihtAthletesDto;


@CrossOrigin
@RestController
@RequestMapping("user")
public class UserController {
	
	
	
	@GetMapping("/ssssss")
	public ResponseEntity<TeamWihtAthletesDto> findAth(@RequestParam Long idTeam,  Authentication authentication){
		return null;
	}

}
