package com.futbolito.security.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class NuevoUsuario {
    @NotBlank
    private String nombre;
    
    @NotBlank
    private String telefono;
    
    @Email
    private String email;
    
    @NotBlank
    private String password;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


	@Override
	public String toString() {
		return "NuevoUsuario [nombre=" + nombre + ", telefono=" + telefono + ", email=" + email + ", password="
				+ password +  "]";
	}
    
    
}
