package com.futbolito.modelo.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Data
@Table(name="DISPUTAS")
public class Disputa {
	
	@Id
	@Column(name="ID_DISPUTAS")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
	private Long id;
	
	@OneToOne
	@JoinColumn(name="ID_PARTIDO")
	private Partido partido;


}
