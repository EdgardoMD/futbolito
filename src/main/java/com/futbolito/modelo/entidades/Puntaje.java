package com.futbolito.modelo.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="PUNTAJES")
public class Puntaje {
	
	
	@Id
	@Column(name="ID_PUNTAJE")
	private Long id;
	
	@OneToOne
	@JoinColumn(name="ID_EQUIPO")
	private Equipo equipo;
	
	@Column(name="PUNTAJE")
	private int puntaje;

}
