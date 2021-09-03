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
@Table(name="EQUIPOS")
public class Equipo {
	
	@Id
	@Column(name="ID_EQUIPO")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="ID_NIVEL")
	private NivelEquipo nivelequipo;
	
	@Column(name="puntaje")
	private int puntaje;

	@Column(name="NOMBRE")
	private String nombre;

}
