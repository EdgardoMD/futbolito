package com.futbolito.modelo.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Data
@Table(name="SOLICITUDES_RESERVA")
public class SolicitudReserva {
	
	@Id
	@Column(name="ID_SOLICITUD")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="ID_ESTADO_SOLICITUD_RESERVA")
	private EstadoSolicitudReserva estadoSolicitudReserva;
	
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
