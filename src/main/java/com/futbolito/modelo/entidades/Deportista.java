package com.futbolito.modelo.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="DEPORTISTAS")
public class Deportista {
	
	
	@Id
	@Column(name="ID_DEPORTISTA")
	private Long id;
	
	@OneToOne
	@JoinColumn(name="ID_USUARIO")
	private Usuario usuario;

	@OneToOne
	@JoinColumn(name="ID_NIVEL")
	private NivelDeportista nivelDeportista;
	
	@ManyToOne
	@JoinColumn(name="CIUDAD")
	private Ciudad ciudad;
	
	@Column(name="ESTATURA")
	private float estatura;
	
	@Column(name="PESO")
	private int peso;
	
	@Column(name="POSICION")
	private String posicion;
	
	@Column(name="PIE")
	private String pie;
	
	@Column(name="NACIMIENTO")
	private String nacimiento;
	
	@Column(name="NICK")
	private String nick;
	
	@Column(name="PERFIL")
	private String fotoPerfil;
	
	
	
	
	
}
