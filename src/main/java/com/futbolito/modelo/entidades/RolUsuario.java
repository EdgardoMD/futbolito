package com.futbolito.modelo.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ROLES_USUARIO")
public class RolUsuario {
	
	@Id
	@Column(name="ID_ROL")
	private int id;
	
	@Column(name="ROL")
	private String rol;


}
