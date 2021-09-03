package com.futbolito.modelo.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="CALIFICACIONES_EQUIPO")
public class CalificacionEquipo {
	
	@Id
	@Column(name="ID_CALIFICACIONES")
	private Long id;
	
	@OneToOne
	@JoinColumn(name="ID_PARTIDO")
	private Partido partido;
	
	@ManyToOne
	@JoinColumn(name="ID_EQUIPO")
	private Equipo equipo;
	
	@Column(name="COMENTARIO")
	private String comentario;

}
