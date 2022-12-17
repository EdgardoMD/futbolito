package com.futbolito.services.implement;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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
		try {
			if (invitationRepository.thisAthleteIsAGuest(idguest, idTeam)) {
				throw new Exception("jugador ya esta invitado a este equipo");
			}
			Athlete athleteGuest = athleteRepository.findById(idguest).orElseThrow();
			Athlete athleteInvites = athleteRepository.findByUserId(idInvites).orElseThrow();
			
			Team team = this.teamRepository.findById(idTeam).orElseThrow();
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
					.findByStatusInvitation(StatusInvitationEnum.CREATED.name()).orElseThrow();
			Invitation invitation = new Invitation(team, athleteGuest, athleteInvites, initialInvitation, LocalDateTime.now());
			Invitation invitationSave = invitationRepository.save(invitation);
			notificationService.createNotification(athleteGuest.getUser(), invitationSave.getIdInvitation(),
					TypeNotificationEnum.TEAM_INVITATION);
			return invitationSave != null && invitationSave.getIdInvitation() != 0;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
		
	}

	@Override
	public Boolean thisAthleteIsAGuest(Long idAthlete, Long idTeam) {
		return invitationRepository.thisAthleteIsAGuest(idAthlete, idTeam);
	}
	
	
	@Transactional
	@Override
	public Boolean acceptInvitationToTeam(Long idTeam, Long Idguest) {
		try {
			Invitation invitation = invitationRepository.findInvitationSendByGuestAndTeam(Idguest, idTeam);
			AthleteTeam athleteTeam = new AthleteTeam(invitation.getTeam(), invitation.getAthleteGuest(), false, LocalDateTime.now());
			atheteTeamRepository.save(athleteTeam);
			invitationRepository.updateInvitaionStatus(StatusInvitationEnum.ACCEPTED.name(), invitation.getIdInvitation());
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
		
	}

}
