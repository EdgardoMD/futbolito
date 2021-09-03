package com.futbolito.modelo.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Data
@Table(name="PARTIDOS")
public class Partido {
	
	@Id
	@Column(name="ID_PARTIDO")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
	private Long id;
	
	@OneToOne
	@JoinColumn(name="ID_SOLICITUD")
	private SolicitudReserva solicitud;
	
	@ManyToOne
	@JoinColumn(name="GANADOR")
	private Equipo equipoGanador;
	
	

}
