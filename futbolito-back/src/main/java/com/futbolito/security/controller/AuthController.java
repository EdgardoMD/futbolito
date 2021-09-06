package com.futbolito.security.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.futbolito.modelo.DTOs.Mensaje;
import com.futbolito.security.dto.JwtDto;
import com.futbolito.security.dto.LoginUsuario;
import com.futbolito.security.dto.NuevoUsuario;
import com.futbolito.security.jwt.JwtProvider;
import com.futbolito.servicio.interfaces.IUsuarioServicio;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

  

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private IUsuarioServicio usuarioService;

   

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity<Mensaje>(new Mensaje("campos mal puestos o email inválido"), HttpStatus.BAD_REQUEST);
        if(usuarioService.existsByEmail(nuevoUsuario.getEmail()))
            return new ResponseEntity<Mensaje>(new Mensaje("ese email ya existe"), HttpStatus.BAD_REQUEST);
       
        usuarioService.crearNuevoUsuario(nuevoUsuario);
        return new ResponseEntity<Mensaje>(new Mensaje("usuario guardado"), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult){
    	System.out.println(loginUsuario);
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("campos mal puestos"), HttpStatus.BAD_REQUEST);
        System.out.println("llego a 1 controller");
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(), loginUsuario.getPassword()));
        System.out.println("llego a 2 controller");
        SecurityContextHolder.getContext().setAuthentication(authentication);
        System.out.println("llego a 3 controller");
        String jwt = jwtProvider.generateToken(authentication);
        System.out.println("llego a 4 controller");
        UserDetails userDetails = (UserDetails)authentication.getPrincipal();
        System.out.println("llego a 5 controller");
        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        System.out.println("llego a 6 controller");
        return new ResponseEntity<JwtDto>(jwtDto, HttpStatus.OK);
    }
}
