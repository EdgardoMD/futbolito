package com.futbolito.modelo.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="HORAS_CANCHA")
public class HoraCancha {
	
	@Id
	@Column(name="ID_HORA_CANCHA")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="ID_ESTADO")
	private EstadoHora estado;
	
	@ManyToOne
	@JoinColumn(name="ID_HORA")
	private Hora hora;
	
	@ManyToOne
	@JoinColumn(name="ID_CANCHA")
	private Cancha cancha;

}
