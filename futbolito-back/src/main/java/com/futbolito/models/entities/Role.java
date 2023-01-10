package com.futbolito.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="ROLES")
public class Role {
	
	@Id
	@Column(name="id_role")
	private int id;
	
	@Column(name="role")
	private String role;


}
