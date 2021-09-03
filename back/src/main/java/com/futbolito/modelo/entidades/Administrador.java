package com.futbolito.modelo.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ADMINISTRADORES")
public class Administrador {
	
	@Id
	@Column(name="ID_ADMINISTRADOR")
	private Long id;
	
	@OneToOne
	@JoinColumn(name="ID_USUARIO")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name="ID_RECINTO")
	private Recinto recinto;


}
