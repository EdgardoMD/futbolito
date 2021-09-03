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
@Table(name="CANCHAS")
public class Cancha {
	
	@Id
	@Column(name="ID_CANCHA")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
	private Long id;
	
	@OneToOne
	@JoinColumn(name="ID_RECINTO")
	private Recinto recinto;
	
	@Column(name="VALOR")
	private int valor;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name="ESTADO_CANCHA_ID")
	private EstadoCancha estadoCancha;

}
