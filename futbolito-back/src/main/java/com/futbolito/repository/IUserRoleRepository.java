package com.futbolito.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.futbolito.models.entities.IDUserRole;
import com.futbolito.models.entities.UserRole;

public interface IUserRoleRepository extends JpaRepository<UserRole, IDUserRole> {

	@Query(value = "SELECT * FROM user_role where user_id = ? ", nativeQuery = true)
	Set<UserRole> listRoleByUserId(Long activo);

}
