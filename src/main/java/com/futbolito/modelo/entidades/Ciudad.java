package com.futbolito.modelo.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="CIUDAD")
public class Ciudad {
	
	
	@Id
	@Column(name="ID_CIUDAD")
	private Long id;
	
	
	@Column(name="CIUDAD")
	private String ciudad;
	
	@ManyToOne
	@JoinColumn(name="ID_REGION")
	private Region region;

}
