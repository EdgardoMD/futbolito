package com.futbolito.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.futbolito.models.DTOs.AthleteDto;
import com.futbolito.services.interfaces.IAthleteService;

@RestController
@RequestMapping("athlete")
public class AthleteController {

	@Autowired
	private IAthleteService athleteService;

	@GetMapping("/search-athlete")
	public ResponseEntity<Object> findAthletesByNickStartswith(@RequestParam String startWith) {
		if (startWith.length() >= 3) {
			List<AthleteDto> athleteDtos = athleteService.findAthletesByNickStartswith(startWith);
			return new ResponseEntity<>(athleteDtos, HttpStatus.OK);
		} else {
			 return ResponseEntity.badRequest().body("El recurso solicitado no se ha encontrado");
		}
	}
}
