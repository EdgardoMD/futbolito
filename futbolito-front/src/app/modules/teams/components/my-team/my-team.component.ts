import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Athlete } from 'src/app/models/athlete.model';
import { InvitationService } from 'src/app/services/invitation.service';
import { TeamsService } from 'src/app/services/teams.service';
import { TeamWithAthletes } from '../../../../models/team-with-athletes';
import { AthleteService } from '../../../../services/athlete.service';

@Component({
  selector: 'app-my-team',
  templateUrl: './my-team.component.html',
  styleUrls: ['./my-team.component.css']
})
export class MyTeamComponent implements OnInit {

  idMyTeam : number = 0;
  team: TeamWithAthletes =  {teamDto:{}, athletesDto:[]};
  athletesFound: Athlete[] = [];
  public search: string = '';

  constructor(
    private teamService : TeamsService,
    private athleteService : AthleteService,
    private invitationService : InvitationService,
    private router : Router
  ) { }

  ngOnInit(): void {
    this. getMyTeams();
  }

  getMyTeams(){
    this.idMyTeam = this.teamService.idMyTeam;
    
    if(this.idMyTeam != 0 ){
      this.teamService.getMyTeam(this.idMyTeam).subscribe(
        team => {
          this.team = team;
        }
       )
    } else {
      this.router.navigate(['my-teams']);
    }
  }

  searchAthlete(nick: any) :void {
    if(this.search.length > 3){
      this.athleteService.searchAthleteByNick(nick).subscribe(
        athletes => {
          this.athletesFound = athletes
        }
       )
    }
  }

  inviteMyTeam(idTeam : any, idAthele: any ){
    this.invitationService.createdInvitationMyTeam( idTeam , idAthele).subscribe(
      response => {
        console.log("responde = "  + response)
      }
    )
  }



 
}
