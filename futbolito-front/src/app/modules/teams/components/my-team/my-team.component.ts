import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { Athlete } from 'src/app/models/athlete.model';
import { InvitationService } from 'src/app/services/invitation.service';
import { TeamsService } from 'src/app/services/teams.service';
import { TeamWithAthletes } from '../../../../models/team-with-athletes';
import { AthleteService } from '../../../../services/athlete.service';
import { DialogComponent } from '../../dialog/dialog.component';

@Component({
  selector: 'app-my-team',
  templateUrl: './my-team.component.html',
  styleUrls: ['./my-team.component.css']
})
export class MyTeamComponent implements OnInit {

  idMyTeam : number = 0;
  team: TeamWithAthletes =  {teamDto:{}, athletesOfTeam:[], athletesGuest:[]};
  teamCharge = false;
 
  

  constructor(
    private teamService : TeamsService,
   
    private router : Router, 
    public dialog: MatDialog,

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
          this.teamCharge = true;
        }
       )
    } else {
      this.router.navigate(['my-teams']);
    }
  }





  openDialog(): void {
    const dialogRef = this.dialog.open(DialogComponent, {
      data: {team : this.team},
      width: '300px'
    });

  }



 
}
