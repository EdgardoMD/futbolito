package com.futbolito.models.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateInvitationTeamDto {

	private Long idTeam;
	private Long idGuest;
 
}
