import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from 'src/app/app-routing.module';
import { NewTeamComponent } from './components/new-team/new-team.component';
import { ListMyTeamsComponent } from './components/list-my-teams/list-my-teams.component';
import { MyTeamComponent } from './components/my-team/my-team.component';
import { TeamComponent } from './components/team/team.component';
import { TeamInvitationsComponent } from './components/team-invitations/team-invitations.component';




@NgModule({
  declarations: [
    ListMyTeamsComponent,
    NewTeamComponent,
    MyTeamComponent,
    TeamComponent,
    TeamInvitationsComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    CommonModule,
    FormsModule
  ]
})
export class TeamsModule { }
