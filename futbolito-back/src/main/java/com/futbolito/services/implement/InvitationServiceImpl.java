package com.futbolito.services.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.futbolito.models.entities.Athlete;
import com.futbolito.models.entities.Invitation;
import com.futbolito.models.entities.StatusInvitation;
import com.futbolito.models.entities.Team;
import com.futbolito.models.enums.StatusInvitationEnum;
import com.futbolito.models.enums.TypeNotificationEnum;
import com.futbolito.repository.IAthleteRepository;
import com.futbolito.repository.IInvitationRepository;
import com.futbolito.repository.IStatusInvitationRepository;
import com.futbolito.repository.ITeamRepository;
import com.futbolito.services.interfaces.IInvitationService;
import com.futbolito.services.interfaces.INotificationService;

@Service
public class InvitationServiceImpl implements IInvitationService {

	@Autowired
	private ITeamRepository teamRepository;

	@Autowired
	private IAthleteRepository athleteRepository;

	@Autowired
	private IStatusInvitationRepository statusInvitationRepository;

	@Autowired
	private IInvitationRepository invitationRepository;
	
	@Autowired
	private INotificationService notificationService;
	
	@Override
	public Invitation save(Invitation obj) {
		return null;
	}

	@Override
	public Invitation update(Invitation obj) {
		return null;
	}

	@Override
	public List<Invitation> toList() {
		return null;
	}

	@Override
	public Invitation getById(Long id) {
		return null;
	}

	@Override
	public boolean delete(Long id) {
		return false;
	}

	@Override
	public Boolean createInvitationToTeam(Long idTeam, Long idguest, Long idInvites) throws Exception {
		Athlete athleteGuest = athleteRepository.findById(idguest).orElseThrow();
		Athlete athleteInvites = athleteRepository.findByUserId(idInvites).orElseThrow();
		Team team = this.teamRepository.findById(idTeam).orElseThrow();
		List<Athlete> athletesBelongingToTeam = athleteRepository.getAthletesByIdTeams(idTeam);
		if(belongsToTheTeam(athletesBelongingToTeam, athleteInvites)) {
			StatusInvitation initialInvitation = statusInvitationRepository.findByStatusInvitation(StatusInvitationEnum.SENT.name()).orElseThrow();
			Invitation invitation = new Invitation(team, athleteGuest, athleteInvites, initialInvitation);
			Invitation invitationSave = invitationRepository.save(invitation);
			notificationService.createNotification(athleteGuest.getUser(), invitationSave.getIdInvitation(), TypeNotificationEnum.TEAM_INVITATION);
			if(invitationSave != null && invitationSave.getIdInvitation() != 0) {
				return true;
			}
		} else {
			throw new Exception("jugador no es parte del equipo");
		}
		return false;
	}

	private Boolean belongsToTheTeam(List<Athlete> athletes, Athlete athleteInvites) {
		
		Long idAthlete = athleteInvites.getIdAthlete();
		for (Athlete athlete : athletes) {
			if (athlete.getIdAthlete() == idAthlete) {
				return true;
			}
		}
		return false;

	}

}
