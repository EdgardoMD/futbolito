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
@Table(name="HORAS_CANCHA")
public class HoraCancha {
	
	@Id
	@Column(name="ID_HORA_CANCHA")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="ID_ESTADO")
	private StatusHours estado;
	
	@ManyToOne
	@JoinColumn(name="ID_HORA")
	private Hour hora;
	
	@ManyToOne
	@JoinColumn(name="ID_CANCHA")
	private Court cancha;

}
