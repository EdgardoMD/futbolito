package com.futbolito.modelo.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="CANCHAS")
public class Cancha {
	
	@Id
	@Column(name="ID_CANCHA")
	private Long id;
	
	@OneToOne
	@JoinColumn(name="ID_RECINTO")
	private Recinto recinto;
	
	@ManyToOne
	@JoinColumn(name="ID_EQUIPO")
	private Equipo equipo;
	
	@Column(name="VALOR")
	private int valor;

}
