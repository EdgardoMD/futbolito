package com.futbolito.modelo.entidades;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@Table(name = "USUARIOS")
public class Usuario {

	@Id
	@Column(name = "ID_USUARIO")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long id;


	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "TELEFONO")
	private String telefono;

	@Column(name = "NOMBRE")
	private String nombre;

	@Column(name = "MAIL")
	private String mail;

	@JsonIgnore
	@Transient
	@OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
	private Set<UsuarioRol> roles = new HashSet<>();

	public Usuario(String nombre,  String telefono, String mail, String password) {
		
		
		this.password = password;
		this.telefono = telefono;
		this.nombre = nombre;
		this.mail = mail;
	}

	public Usuario() {
		
	}

	
	
	
}
