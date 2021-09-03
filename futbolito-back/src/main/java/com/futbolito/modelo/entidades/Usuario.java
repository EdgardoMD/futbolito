package com.futbolito.modelo.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Data
@Table(name="USUARIOS")
public class Usuario {
	
	@Id
	@Column(name="ID_USUARIO")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
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
