package com.futbolito.services.implement;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.futbolito.models.entities.Athlete;
import com.futbolito.models.entities.AthleteTeam;
import com.futbolito.models.entities.Invitation;
import com.futbolito.models.entities.StatusInvitation;
import com.futbolito.models.entities.Team;
import com.futbolito.models.enums.StatusInvitationEnum;
import com.futbolito.models.enums.TypeNotificationEnum;
import com.futbolito.repository.IAtheteTeamRepository;
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
	
	@Autowired
	private IAtheteTeamRepository atheteTeamRepository;

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
		//falta comprobar si el jugador al que se esta invitando no es ya parte del equipo
		//tambien comprobar esto en el front
		//comprobar si el jugador invitado no ha sido Ya invtado a la espera de aprobacion
		Athlete athleteGuest = athleteRepository.findById(idguest).orElseThrow();
		Athlete athleteInvites = athleteRepository.findByUserId(idInvites).orElseThrow();
		Team team = this.teamRepository.findById(idTeam).orElseThrow();
		List<Athlete> athletesBelongingToTeam = athleteRepository.getAthletesByIdTeams(idTeam);
		if (!athletesBelongingToTeam.contains(athleteInvites)) {
			throw new Exception("jugador no es parte del equipo");
		}
		StatusInvitation initialInvitation = statusInvitationRepository
				.findByStatusInvitation(StatusInvitationEnum.CREATED.name()).orElseThrow();
		Invitation invitation = new Invitation(team, athleteGuest, athleteInvites, initialInvitation);
		Invitation invitationSave = invitationRepository.save(invitation);
		notificationService.createNotification(athleteGuest.getUser(), invitationSave.getIdInvitation(),
				TypeNotificationEnum.TEAM_INVITATION);
		return invitationSave != null && invitationSave.getIdInvitation() != 0;
	}

	@Override
	public Boolean thisAthleteIsAGuest(Long idAthlete, Long idTeam) {
		return invitationRepository.thisAthleteIsAGuest(idAthlete, idTeam);
	}
	
	
	@Transactional
	@Override
	public Boolean acceptInvitationToTeam(Long idTeam, Long Idguest) {
		Invitation invitation = invitationRepository.findInvitationSendByGuestAndTeam(Idguest, idTeam);
		AthleteTeam athleteTeam = new AthleteTeam(invitation.getTeam(), invitation.getAthleteGuest());
		atheteTeamRepository.save(athleteTeam);
		invitationRepository.updateInvitaionStatus(StatusInvitationEnum.ACCEPTED.name(), invitation.getIdInvitation());
		return true;
	}

}
