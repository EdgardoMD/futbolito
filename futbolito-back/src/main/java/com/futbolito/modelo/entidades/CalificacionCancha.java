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
@Table(name="CALIFICACIONES_CANCHA")
public class CalificacionCancha {
	
	@Id
	@Column(name="ID_CALIFICACION")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
	private Long id;
	
	@OneToOne
	@JoinColumn(name="ID_PARTIDO")
	private Partido partido;
	
	@ManyToOne
	@JoinColumn(name="ID_RECINTO")
	private Recinto recinto;
	
	@Column(name="COMENTARIO")
	private String comentario;

}
