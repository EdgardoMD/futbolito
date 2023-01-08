import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'
import { Athlete } from '../models/athlete.model';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class PerfilService {

  profileURL: string = environment.apiUrl + '/profile';

  perfil: Athlete = {} ;

  constructor(
    private http : HttpClient
  ) { }

  getPerfil() {
  return this.http.get<Athlete>(this.profileURL + '/athlete')
  }
}
