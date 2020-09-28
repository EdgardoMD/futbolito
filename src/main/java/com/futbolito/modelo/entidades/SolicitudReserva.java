package com.futbolito.modelo.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="SOLICITUDES_RESERVA")
public class SolicitudReserva {
	
	@Id
	@Column(name="ID_SOLICITUD")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="ID_ESTADO")
	private EstadoSolicitud estado;
	
	@ManyToOne
	@JoinColumn(name="ID_HORA")
	private HoraCancha hora;
	
	@ManyToOne
	@JoinColumn(name="ID_EQUIPO1")
	private Equipo equipo1;
	
	@ManyToOne
	@JoinColumn(name="ID_EQUIPO2")
	private Equipo equipo2;

}
