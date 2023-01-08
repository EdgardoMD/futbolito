import { ChangeDetectorRef, Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { TeamWithAthletes } from 'src/app/models/team-with-athletes';
import { InvitationService } from 'src/app/services/invitation.service';
import { TeamsService } from 'src/app/services/teams.service';
import { MatDialog } from '@angular/material/dialog';
import { Dialog } from '@angular/cdk/dialog';
import { DialogComponent } from '../../dialog/dialog.component';
import {
  MatSnackBar,
  MatSnackBarHorizontalPosition,
  MatSnackBarVerticalPosition,
} from '@angular/material/snack-bar';

@Component({
  selector: 'app-team',
  templateUrl: './team.component.html',
  styleUrls: ['./team.component.css']
})
export class TeamComponent implements OnInit {

  horizontalPosition: MatSnackBarHorizontalPosition = 'start';
  verticalPosition: MatSnackBarVerticalPosition = 'bottom';


  idTeam: number = 0;

  team: TeamWithAthletes =  {teamDto:{}, athletesOfTeam:[], athletesGuest:[]};

  constructor(
    private rutaActiva: ActivatedRoute,
    private teamService: TeamsService,
    private invitationService : InvitationService,
    public dialog: MatDialog,
    private _snackBar: MatSnackBar,
    private cd: ChangeDetectorRef,
    
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
        if(response){
          this.openSnackBar("ya eres parte de este equipo!!");
          this.getTeam();
          this.cd.detectChanges();
        } else {
          this.openSnackBar("hubo un error al intentar incorporarte a este equipo")
        }
        
      }, error =>{
        this.openSnackBar("hubo un error al intentar incorporarte a este equipo")
      }
    )
  }

  rejectInvitationTeam(){
    this.invitationService.acceptInvitationTeam(this.idTeam).subscribe(
      response => {
        if(response){
          this.openSnackBar("has rechazado la invitacion");
          this.getTeam();
        } else {
          this.openSnackBar("hubo un error al intentar rechazar la invitacion")
        }
        
      }, error =>{
        this.openSnackBar("hubo un error al intentar rechazar la invitacion")
      }
    )
  }

  openSnackBar(message : string) {
    this._snackBar.open(message, '', {
      duration:  3000,
      horizontalPosition: this.horizontalPosition,
      verticalPosition: this.verticalPosition,
    });
  }







}
