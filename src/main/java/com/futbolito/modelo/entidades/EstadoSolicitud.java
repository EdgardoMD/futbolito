package com.futbolito.modelo.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ESTADOS_SOLICITUD")
public class EstadoSolicitud {
	
	@Id
	@Column(name="ID_ESTADO")
	private Long id;
	
	@Column(name="ESTADO")
	private String estado;

}
