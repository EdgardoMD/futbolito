package com.futbolito.modelo.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="NIVELES_DEPORTISTA")
public class NivelDeportista {
	
	@Id
	@Column(name="ID_NIVEL")
	private int id;
	
	@Column(name="NIVEL")
	private String nivel;
	
	@Column(name="PUNTAJE_REQUERIDO")
	private int puntajeRequerido;


}
