package com.futbolito.modelo.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="REGION")
public class Region {
	
	@Id
	@Column(name="ID_REGION")
	private Long id;
	
	@Column(name="REGION")
	private String region;

}
