package com.futbolito.modelo.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

import javax.persistence.ForeignKey;

@Entity
@Table(name="usuario_rol")
@IdClass(IDUsuarioRol.class)
@Data
public class UsuarioRol {
	
	@Id
	@ManyToOne
	@JoinColumn(name="user_id", foreignKey = @ForeignKey(name = "FK_usuario_rol_usuario"))
	private Usuario usuario;
	
	@Id
	@ManyToOne
	@JoinColumn(name="rol_id", foreignKey = @ForeignKey(name = "FK_usuario_rol_rol"))
	private Rol rol;

}
