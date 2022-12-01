import { Component, OnInit } from '@angular/core';
import { TeamWithAthletes } from '../../models/team-with-athletes';
import { TeamsService } from '../../services/teams.service';

@Component({
  selector: 'app-my-team',
  templateUrl: './my-team.component.html',
  styleUrls: ['./my-team.component.css']
})
export class MyTeamComponent implements OnInit {

  idMyTeam : number = 0;
  team: TeamWithAthletes = {};

  constructor(
    private teamService : TeamsService
  ) { }

  ngOnInit(): void {
   this. getMyTeams();
   
  }

  getMyTeams(){
    this.idMyTeam = this.teamService.idMyTeam;
   this.teamService.getMyTeam(this.idMyTeam).subscribe(
    myTeam => {
      this.team = myTeam;
      console.log(this.team);
    }
   )
  

  }

}
