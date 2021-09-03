package com.futbolito.modelo.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="EQUIPOS")
public class Equipo {
	
	@Id
	@Column(name="ID_EQUIPO")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="ID_NIVEL")
	private NivelEquipo nivelequipo;
	
	@ManyToOne
	@JoinColumn(name="CIUDAD")
	private Ciudad ciudad;
	
	@Column(name="PESO")
	private int peso;


}
