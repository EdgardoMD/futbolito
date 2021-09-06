package com.futbolito.modelo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.modelo.entidades.IDUsuarioRol;
import com.futbolito.modelo.entidades.UsuarioRol;

public interface IUsuarioRolREpositorio extends JpaRepository<UsuarioRol, IDUsuarioRol> {

}
