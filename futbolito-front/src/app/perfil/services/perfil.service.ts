import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'
import { Athlete } from '../model/athlete.model';

@Injectable({
  providedIn: 'root'
})
export class PerfilService {

  perfil: Athlete = {} ;

  constructor(
    private http : HttpClient
  ) { }

  getPerfil() {
  return this.http.get<Athlete>('http://localhost:9999/profile/athlete')
  }
}
