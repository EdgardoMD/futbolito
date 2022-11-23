package com.futbolito.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="qualifications_teams")
public class QualificationTeam {
	
	@Id
	@Column(name="id_qualification_team")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
	private Long idQualificationTeam;
	
	@OneToOne
	@JoinColumn(name="match")
	private Match match;
	
	@ManyToOne
	@JoinColumn(name="team")
	private Team team;
	
	@Column(name="comment")
	private String comment;

}
