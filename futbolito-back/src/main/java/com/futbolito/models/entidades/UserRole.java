package com.futbolito.models.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ForeignKey;

@Entity
@Table(name="user_role")
@IdClass(IDUserRole.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRole {
	
	@Id
	@ManyToOne
	@JoinColumn(name="user_id", foreignKey = @ForeignKey(name = "FK_user_role_user"))
	private User user;
	
	@Id
	@ManyToOne
	@JoinColumn(name="role_id", foreignKey = @ForeignKey(name = "FK_user_role_role"))
	private Role role;

	
}
