package com.futbolito.modelo.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="COMENTARIOS_DEPORTISTA")
public class ComentarioDeportista {
	
	@Id
	@Column(name="ID_COMENTARIO")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="ID_DEPORTISTA")
	private Deportista deportista;
	
	@OneToOne
	@JoinColumn(name="ID_PARTIDO")
	private Partido partido;
	
	@Column(name="COMENTARIO")
	private String comentario;

}
