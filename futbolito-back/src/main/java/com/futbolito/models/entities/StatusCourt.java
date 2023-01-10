package com.futbolito.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="status_Courts")
public class StatusCourt {
	
	@Id
	@Column(name="id_status_Courts")
	private Long id;
	
	@Column(name="status")
	private String status;

}
