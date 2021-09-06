package com.futbolito.modelo.entidades;

import java.io.Serializable;

import lombok.Data;

 @Data
public class IDUsuarioRol implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long usuario;
	
	private int rol;
	
	

}
