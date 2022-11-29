import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Team } from '../models/team';

@Injectable({
  providedIn: 'root'
})
export class TeamsService {

  teamsURL: string = environment.apiUrl + '/team';

  constructor(private httpClient: HttpClient) { }

  public newTeam(newTeam: Team) : Observable<Team>{
    return this.httpClient.post<Team>(this.teamsURL + '/new-team', newTeam)
  }

  public getMyTeams() : Observable<Team[]>{
    return this.httpClient.get<Team[]>(this.teamsURL + '/my-teams')
  }


}
