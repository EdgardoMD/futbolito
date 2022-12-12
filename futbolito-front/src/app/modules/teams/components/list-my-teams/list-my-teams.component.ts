import { Component, OnInit } from '@angular/core';
import { Router, RouterLink } from '@angular/router';
import { Team } from 'src/app/models/team';
import { TeamsService } from 'src/app/services/teams.service';

@Component({
  selector: 'app-list-my-teams',
  templateUrl: './list-my-teams.component.html',
  styleUrls: ['./list-my-teams.component.css']
})
export class ListMyTeamsComponent implements OnInit {

  teams: Team[] = [];
  idTeam : number = 0;

  constructor(
    private teamService : TeamsService,
    private router : Router
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

  viewMyTeam(idTeam:any){
    this.idTeam = idTeam;
    this.teamService.setIdMyTeam(this.idTeam);
    this.router.navigate(['my-team']);
  }

}
