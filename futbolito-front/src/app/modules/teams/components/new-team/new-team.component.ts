import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Team } from 'src/app/models/team';
import { TeamsService } from '../../services/teams.service';

@Component({
  selector: 'app-new-team',
  templateUrl: './new-team.component.html',
  styleUrls: ['./new-team.component.css'],
  exportAs: 'ngForm'
})
export class NewTeamComponent implements OnInit {

  city: string = '';
  idCity: number = 0 ;
  name: string ='';
  team: Team = {};

  constructor(
    private teamService: TeamsService, 
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  createNewTeam():void{
    console.log("creando nuevo equipo");
    this.team = new Team(this.name, this.idCity)
    this.teamService.newTeam(this.team).subscribe(
      team =>{
        this.router.navigate(['my-teams']);
      }
      
    )
  }

}
