package com.futbolito.modelo.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="DISPUTAS")
public class Disputa {
	
	@Id
	@Column(name="ID_DISPUTAS")
	private Long id;
	
	@OneToOne
	@JoinColumn(name="ID_PARTIDO")
	private Partido partido;


}
