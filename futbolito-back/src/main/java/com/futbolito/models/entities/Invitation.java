package com.futbolito.models.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "invitation")
public class Invitation {

	@Id
	@Column(name = "id_invitation")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long idInvitation;

	@ManyToOne
	@JoinColumn(name = "id_team")
	private Team team;

	@ManyToOne
	@JoinColumn(name = "id_athlete_guest")
	private Athlete athleteGuest;

	@ManyToOne
	@JoinColumn(name = "id_athlete_invites")
	private Athlete athleteInvites;

	@ManyToOne
	@JoinColumn(name = "id_status_invitation")
	private StatusInvitation statusInvitation;
	
	@Column(name="creation_date", updatable = false, nullable = false)
	private LocalDateTime creationDate;
	
	@Column(name="update_date")
	private LocalDateTime updateDate;

	public Invitation(Team team, Athlete athleteGuest, Athlete athleteInvites, StatusInvitation statusInvitation) {
		this.team = team;
		this.athleteGuest = athleteGuest;
		this.athleteInvites = athleteInvites;
		this.statusInvitation = statusInvitation;
	}

}
