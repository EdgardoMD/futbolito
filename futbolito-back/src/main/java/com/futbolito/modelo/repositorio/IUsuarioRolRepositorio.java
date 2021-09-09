package com.futbolito.modelo.repositorio;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.futbolito.modelo.entidades.IDUsuarioRol;
import com.futbolito.modelo.entidades.UsuarioRol;

public interface IUsuarioRolRepositorio extends JpaRepository<UsuarioRol, IDUsuarioRol> {

	@Query(value = "SELECT * FROM usuario_rol where user_id = ? ", nativeQuery = true)
	Set<UsuarioRol> listarRolesPorUsuario(Long activo);

}
