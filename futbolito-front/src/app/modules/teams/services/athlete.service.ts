import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Athlete } from '../../perfil/model/athlete.model';

@Injectable({
  providedIn: 'root'
})
export class AthleteService {

  athleteURL: string = environment.apiUrl + '/athlete';

  constructor(private httpClient: HttpClient) { }


  public searchAthleteByNick(nick: string):Observable<Athlete[]>{
    let param: any = {'startWith': nick};
    return this.httpClient.get<Athlete[]>(this.athleteURL + '/search-athlete' , {params: param});
  }
}
