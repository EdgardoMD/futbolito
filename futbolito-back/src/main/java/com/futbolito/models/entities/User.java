package com.futbolito.models.entities;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

	@Id
	@Column(name = "ID_USER")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long idUser;

	@JsonIgnore
	@Column(name = "PASSWORD")
	private String password;

	@JsonIgnore
	@Column(name = "phone")
	private String phone;

	@JsonIgnore
	@Column(name = "name")
	private String name;

	@JsonIgnore
	@Column(name = "MAIL")
	private String mail;
	
	@Column(name = "nick_name")
	private String nickName;
	
	@Column(name="creation_date", updatable = false, nullable = false)
	private LocalDateTime creationDate;
	
	@Column(name="update_date")
	private LocalDateTime updateDate;

	@JsonIgnore
	@Transient
	@OneToMany(mappedBy = "users", fetch = FetchType.LAZY)
	private Set<UserRole> roles = new HashSet<>();

	

	
	
	
}
