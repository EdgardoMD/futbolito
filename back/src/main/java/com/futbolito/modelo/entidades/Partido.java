package com.futbolito.modelo.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="PARTIDOS")
public class Partido {
	
	@Id
	@Column(name="ID_PARTIDO")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="ID_CANCHA")
	private Cancha cancha;
	
	@OneToOne
	@JoinColumn(name="ID_SOLICITUD")
	private SolicitudReserva solicitud;
	
	@ManyToOne
	@JoinColumn(name="GANADOR")
	private Equipo equipoGanador;
	
	

}
