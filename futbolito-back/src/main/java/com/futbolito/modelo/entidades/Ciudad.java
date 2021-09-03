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
@Table(name="CIUDAD")
public class Ciudad {
	
	
	@Id
	@Column(name="ID_CIUDAD")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
	private Long id;
	
	
	@Column(name="CIUDAD")
	private String ciudad;
	
	@ManyToOne
	@JoinColumn(name="ID_REGION")
	private Region region;

}
