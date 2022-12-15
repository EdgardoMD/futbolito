import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { TeamWithAthletes } from 'src/app/models/team-with-athletes';
import { InvitationService } from 'src/app/services/invitation.service';
import { TeamsService } from 'src/app/services/teams.service';

@Component({
  selector: 'app-team',
  templateUrl: './team.component.html',
  styleUrls: ['./team.component.css']
})
export class TeamComponent implements OnInit {

  idTeam: number = 0;

  team: TeamWithAthletes =  {teamDto:{}, athletesDto:[]};

  constructor(
    private rutaActiva: ActivatedRoute,
    private teamService: TeamsService,
    private invitationService : InvitationService
  ) { }


  ngOnInit(): void {
    this.idTeam = this.rutaActiva.snapshot.params.param;
    this.getTeam();
  }

  getTeam(){
    this.teamService.getTeam(this.idTeam).subscribe(
      response => {
        this.team = response;
      }
    )
  }

  acceptInvitationTeam(){
    this.invitationService.acceptInvitationTeam(this.idTeam).subscribe(
      response => {
        console.log(response)
      }
    )
  }

}
