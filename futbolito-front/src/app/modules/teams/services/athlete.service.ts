import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Athlete } from 'src/app/perfil/model/athlete.model';
import { environment } from 'src/environments/environment';

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
