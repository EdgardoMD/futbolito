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

@Entity
@Table(name="athlete_comments")
public class AthleteComment {
	
	@Id
	@Column(name="is_athlete_comments")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="id_athlete")
	private Athlete athlete;
	
	@OneToOne
	@JoinColumn(name="id_match")
	private Match match;
	
	@Column(name="COMENTARIO")
	private String comentario;

}
