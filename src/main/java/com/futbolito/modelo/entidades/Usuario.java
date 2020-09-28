package com.futbolito.modelo.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="USUARIOS")
public class Usuario {
	
	@Id
	@Column(name="ID_USUARIO")
	private Long id;
	
	@OneToOne
	@JoinColumn(name="ID_ROL")
	private RolUsuario rol;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="TELEFONO")
	private String telefono;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="MAIL")
	private String mail;
	
	
	

}
