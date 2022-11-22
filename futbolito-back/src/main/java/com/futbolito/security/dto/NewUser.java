package com.futbolito.security.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewUser {
	
    @NotBlank
    private String nombre;
    
    @NotBlank
    private String telefono;
    
    @Email
    private String email;
    
    @NotBlank
    private String password;

}
