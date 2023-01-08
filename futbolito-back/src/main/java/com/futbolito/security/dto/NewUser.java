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
    private String name;
    
//    @NotBlank
//    private String lastName;
    
    @NotBlank
    private String nickname;
    
//    @NotBlank
//    private String phone;
    
    @Email
    private String email;
    
    @NotBlank
    private String password;
    
//    @NotBlank
//    private String confirmationPassword;

}
