import { Component, OnInit } from '@angular/core';
import { Team } from '../../models/team';
import { TeamsService } from '../../services/teams.service';

@Component({
  selector: 'app-list-my-teams',
  templateUrl: './list-my-teams.component.html',
  styleUrls: ['./list-my-teams.component.css']
})
export class ListMyTeamsComponent implements OnInit {

  teams: Team[] = [];

  constructor(
    private teamService : TeamsService
  ) { }

  ngOnInit(): void {
    this.getMyTeams();
   
  }

  getMyTeams(){
   this.teamService.getMyTeams().subscribe(
    myTeams =>{
      this.teams = myTeams;
      
    }
   )
  }

}
