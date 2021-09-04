package com.futbolito.controller.perfil;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.futbolito.modelo.entidades.Deportista;


@CrossOrigin
@RestController
@RequestMapping("perfil")
public class PerfilController {
	
	@GetMapping
	public ResponseEntity<Deportista> getForeignExchange(/* Authentication authentication*/){
		
		System.out.println("pide");
		
		Deportista dto = new Deportista();
		dto.setId(1l);
		dto.setNacimiento("nacimiento");
		dto.setEstatura(1.70f);
		dto.setFotoPerfil("link foto");
		dto.setNick("nickiki");
		
		System.out.println(dto);
		
		return new ResponseEntity<Deportista>(dto, HttpStatus.OK);
	}

}
