import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { Athlete } from 'src/app/models/athlete.model';
import { TeamWithAthletes } from 'src/app/models/team-with-athletes';
import { AthleteService } from 'src/app/services/athlete.service';
import { InvitationService } from 'src/app/services/invitation.service';
import {MAT_DIALOG_DATA} from '@angular/material/dialog';
import { FormControl } from '@angular/forms';
import { map, Observable, startWith } from 'rxjs';
import { MatSnackBar, MatSnackBarHorizontalPosition, MatSnackBarVerticalPosition } from '@angular/material/snack-bar';



@Component({
  selector: 'app-dialog',
  templateUrl: './dialog.component.html',
  styleUrls: ['./dialog.component.css']
})
export class DialogComponent implements OnInit{

  myControl = new FormControl();
  public search: string = '';
  athletesFound: Athlete[] = [];
  options: string[] = [];
  filteredOptions: Observable<string[]> = new Observable<string[]>;

  horizontalPosition: MatSnackBarHorizontalPosition = 'start';
  verticalPosition: MatSnackBarVerticalPosition = 'bottom';

  constructor(
    public dialogRef: MatDialogRef<DialogComponent>,
    private athleteService : AthleteService,
    private invitationService : InvitationService,
    private _snackBar: MatSnackBar,
    @Inject(MAT_DIALOG_DATA) public team: {team: TeamWithAthletes}
  ){}
  
  ngOnInit(): void {
    this.filteredOptions = this.myControl.valueChanges.pipe(
     
      startWith(''),
      map(value => this.searchAthlete(value || '')),
    );
  }


  searchAthlete(nick: any): string[] {
    this.search = nick;
    if (this.search.length >= 3) {
      this.athleteService.searchAthleteByNick(nick).subscribe(
        athletes => {
          this.athletesFound = athletes;
          this.athletesFound = this.athletesFound.filter(athlete => {
            const athletesOfTeamIds = this.team.team.athletesOfTeam.map(a => a.idUser);
            if(this.team.team.athletesGuest != null){
              const athletesGuestIds = this.team.team.athletesGuest.map(a => a.idUser);
              return !athletesOfTeamIds.includes(athlete.idUser) && !athletesGuestIds.includes(athlete.idUser);
            } else {
              return !athletesOfTeamIds.includes(athlete.idUser);
            }
            
           
          });
          this.options = this.athletesFound
            .map(athlete => athlete.nick !== undefined ? athlete.nick : '')
            .filter(option => option !== '');
        }
      )
      return this.options.filter(option => option.toLowerCase().includes(nick.toLowerCase()))
    } else {
      this.options = [];
      return [];
    }
  }


  inviteMyTeam(  ){
     const idTeam : number = this.team.team.teamDto.id !== undefined ? this.team.team.teamDto.id : 0 ;
     const selectedValue = this.myControl.value;
     const athleteGuest : number = this.defineGuestAthleteId(selectedValue);
    this.defineGuestAthleteId(selectedValue);
    this.invitationService.createdInvitationMyTeam( idTeam , athleteGuest).subscribe(
      response => {
        this.closeDialog();
         this.openSnackBar("invitacion enviada con exito")
      }, err => {
        this.closeDialog();
        this.openSnackBar("error al enviar la invitacion")
      }
    )   
  }

  closeDialog(): void {
    this.dialogRef.close();
  }

  defineGuestAthleteId(selectedValue: string): number {

    let athlete;
    if (this.athletesFound.find(athlete => athlete.nick == selectedValue)) {
      athlete = this.athletesFound.find(athlete => athlete.nick == selectedValue);
    }
    if(athlete  && athlete.idUser ){
      return athlete.idUser;
    } else {
      return 0;
    }
  }


  openSnackBar(message : string) {
    this._snackBar.open(message, '', {
      duration:  3000,
      horizontalPosition: this.horizontalPosition,
      verticalPosition: this.verticalPosition,
    });
  }

}
