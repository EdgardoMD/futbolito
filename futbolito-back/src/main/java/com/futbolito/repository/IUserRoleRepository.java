package com.futbolito.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.futbolito.modelo.entidades.IDUserRole;
import com.futbolito.modelo.entidades.UserRole;

public interface IUserRoleRepository extends JpaRepository<UserRole, IDUserRole> {

	@Query(value = "SELECT * FROM usuario_rol where user_id = ? ", nativeQuery = true)
	Set<UserRole> listRoleByUserId(Long activo);

}
