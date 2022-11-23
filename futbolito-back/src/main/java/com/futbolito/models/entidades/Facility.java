package com.futbolito.models.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="facilitys")
public class Facility {
	
	@Id
	@Column(name="is_facility")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
	private Long idFacilitys;
	
	@Column(name="name")
	private String name;
	
	@Column(name="direction")
	private String direction;
	
	@Column(name="location")
	private String location;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="RUT")
	private String rut;


}
