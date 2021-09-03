package com.futbolito.modelo.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="HORAS")
public class Hora {
	
	@Id
	@Column(name="ID_HORA")
	private Long id;
	
	@Column(name="HORA")
	private String hora;

}
