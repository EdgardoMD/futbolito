package com.futbolito.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import com.futbolito.models.enums.StatusInvitationEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "status_invitation")
public class StatusInvitation {
	
	@Id
	@Column(name = "id_status_invitation")
	private Long idStatusInvitation;
	
	@Column(name="status_invitation")
	@Enumerated(EnumType.STRING)
	private StatusInvitationEnum statusInvitation;

}
