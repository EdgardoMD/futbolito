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
@Table(name="DEPORTISTA_PARTIDO")
public class DeportistaPartido {
	
	@Id
	@Column(name="ID_DEPORTISTA_PARTIDO")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="PARTIDO_ID")
	private Partido partido;
	
	@ManyToOne
	@JoinColumn(name="EQUIPO_ID")
	private Equipo equipo;
	
	@ManyToOne
	@JoinColumn(name="DEPORTISTA_ID")
	private Deportista deportista;
	
	

	
	

}
