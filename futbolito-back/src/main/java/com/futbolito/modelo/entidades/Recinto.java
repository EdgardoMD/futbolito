package com.futbolito.modelo.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Data
@Table(name="RECINTOS")
public class Recinto {
	
	@Id
	@Column(name="ID_RECINTO")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
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
