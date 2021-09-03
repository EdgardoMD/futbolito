package com.futbolito.modelo.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="DEPORTISTA_PARTIDO")
public class DeportistaPartido {
	
	@Id
	@Column(name="ID_DEPORTISTA_PARTIDO")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="PARTIDO_ID")
	private Partido partido;
	
	@ManyToOne
	@JoinColumn(name="EQUIPO_ID")
	private Equipo equipo;
	
	@ManyToOne
	@JoinColumn(name="DEPORTISTA_ID")
	private Deportista deportista;
	
	

	
	

}
