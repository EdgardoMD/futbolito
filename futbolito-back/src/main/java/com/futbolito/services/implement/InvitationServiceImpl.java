package com.futbolito.services.implement;

import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.futbolito.models.entities.Athlete;
import com.futbolito.models.entities.AthleteTeam;
import com.futbolito.models.entities.Invitation;
import com.futbolito.models.entities.StatusInvitation;
import com.futbolito.models.entities.Team;
import com.futbolito.models.entities.User;
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
	
	Logger logger = Logger.getLogger(InvitationServiceImpl.class.getName());

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
		try {
			if (invitationRepository.thisAthleteIsAGuest(idguest, idTeam)) {
				throw new Exception("jugador ya esta invitado a este equipo");
			}
			Athlete athleteGuest = athleteRepository.findById(idguest).orElseThrow(() -> new Exception("No se encontró el atleta invitado"));
			Athlete athleteInvites = athleteRepository.findByUserId(idInvites).orElseThrow(() -> new Exception("No se encontró el atleta que invita"));
			
			Team team = this.teamRepository.findById(idTeam).orElseThrow(() -> new Exception("No se encontró el equipo"));
			List<Athlete> athletesBelongingToTeam = team.getAthletesTeam().stream()
				    .map(AthleteTeam::getAthlete).collect(Collectors.toList());
			if (!athletesBelongingToTeam.contains(athleteInvites)) {
				throw new Exception("jugador que invita no es parte del equipo");
			}
			if (athletesBelongingToTeam.contains(athleteGuest)) {
				throw new Exception("jugador invitado ya es parte del equipo");
			}
			AthleteTeam athleteTeam = team.getAthletesTeam().stream().filter(
					at -> at.getAthlete().equals(athleteInvites)).findFirst().orElse(null);
			if(athleteTeam.getIsCaptain() == null || !athleteTeam.getIsCaptain()) {
				throw new Exception("un jugador no capitan no puede invitar a un equipo");
			}
			StatusInvitation initialInvitation = statusInvitationRepository
					.findByStatusInvitation(StatusInvitationEnum.CREATED.name()).orElseThrow(() -> new Exception("No se encontró el estatus creado de invitacion"));
			Invitation invitation = new Invitation(team, athleteGuest, athleteInvites, initialInvitation, LocalDateTime.now());
			Invitation invitationSave = invitationRepository.save(invitation);
			notificationService.createNotification(athleteGuest.getUser(), invitationSave.getIdInvitation(),
					TypeNotificationEnum.TEAM_INVITATION);
			return invitationSave != null && invitationSave.getIdInvitation() != 0;
		} catch (Exception e) {
			logger.severe(e.getMessage());
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	@Transactional
	public Boolean thisAthleteIsAGuest(Long idAthlete, Long idTeam) {
		return invitationRepository.thisAthleteIsAGuest(idAthlete, idTeam);
	}
	
	
	
	@Transactional
	public Boolean acceptInvitationToTeam(Long idTeam, Long Idguest) {
		try {
			Invitation invitation = invitationRepository.findInvitationSendByGuestAndTeam(Idguest, idTeam).orElseThrow(()-> new Exception("no se encontro invitacion activa"));
			AthleteTeam athleteTeam = new AthleteTeam(invitation.getTeam(), invitation.getAthleteGuest(), false, LocalDateTime.now());
			this.acceptInvitation(invitation, athleteTeam);
			this.notifynewAthlete(invitation);
			return true;
		} catch (Exception e) {
			logger.severe(e.getMessage());
			e.printStackTrace();
			return false;
		}
		
	}
	
	
	
	@Transactional
	private void acceptInvitation(Invitation invitation, AthleteTeam athleteTeam ) throws Exception {
		try {
			atheteTeamRepository.save(athleteTeam);
			invitationRepository.updateInvitaionStatus(StatusInvitationEnum.ACCEPTED.name(), invitation.getIdInvitation());
		} catch (Exception e) {
			throw new Exception("problemas al guardar la aceptacion de la invitacion", e);
		}
		
	}
	
	@Async
	private void notifynewAthlete(Invitation invitation) {
		
		List<User> users = invitation.getTeam().getAthletesTeam().stream()
			    .map(AthleteTeam::getAthlete)
			    .map(Athlete::getUser)
			    .collect(Collectors.toList());
		User invitesUser = invitation.getAthleteInvites().getUser();
		users.remove(invitesUser);
		notificationService.createListNotifications(users, invitation.getIdInvitation(), TypeNotificationEnum.NEW_MEMBER_TEAM);
		notificationService.createNotification(invitesUser, invitation.getIdInvitation(), TypeNotificationEnum.INVITATION_ACCEPTED);
	}
	
	@Override
	public Boolean rejectInvitationToTeam(Long idTeam, Long Idguest) {
		try {
			Invitation invitation = invitationRepository.findInvitationSendByGuestAndTeam(Idguest, idTeam).orElseThrow(()-> new Exception("no se encontro invitacion activa"));
			this.rejectInvitation(invitation);
			this.notifyRejectInvitation(invitation);
			return true;
		} catch (Exception e) {
			logger.severe(e.getMessage());
			e.printStackTrace();
			return false;
		}
		
	}
	
	
	@Transactional
	private void rejectInvitation(Invitation invitation) throws Exception {
		try {
			invitationRepository.updateInvitaionStatus(StatusInvitationEnum.REJECTED.name(), invitation.getIdInvitation());
		} catch (Exception e) {
			throw new Exception("problemas al guardar la aceptacion de la invitacion", e);
		}
		
	}
	
	@Async
	private void notifyRejectInvitation(Invitation invitation) {
		notificationService.createNotification(invitation.getAthleteInvites().getUser(), invitation.getIdInvitation(), TypeNotificationEnum.INVITATION_REJECTION);
	}

}
