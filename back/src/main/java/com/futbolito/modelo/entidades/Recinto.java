package com.futbolito.modelo.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="RECINTOS")
public class Recinto {
	
	@Id
	@Column(name="ID_RECINTO")
	private Long id;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="DIRECCION")
	private String Direccion;
	
	@Column(name="UBICACION")
	private String Ubicacion;
	
	@Column(name="TELEFONO")
	private String telefono;
	
	@Column(name="RUT")
	private String rut;


}
