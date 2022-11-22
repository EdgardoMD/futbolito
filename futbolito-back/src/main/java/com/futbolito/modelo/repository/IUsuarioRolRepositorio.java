package com.futbolito.modelo.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.futbolito.modelo.entidades.IDUserRole;
import com.futbolito.modelo.entidades.UserRole;

public interface IUsuarioRolRepositorio extends JpaRepository<UserRole, IDUserRole> {

	@Query(value = "SELECT * FROM usuario_rol where user_id = ? ", nativeQuery = true)
	Set<UserRole> listarRolesPorUsuario(Long activo);

}
