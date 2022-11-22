import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'
import { Perfil } from '../model/perfil.model';

@Injectable({
  providedIn: 'root'
})
export class PerfilService {

  perfil: Perfil = {} ;

  constructor(
    private http : HttpClient
  ) { }

  getPerfil() {
  return this.http.get<Perfil>('http://localhost:9999/profile')
  }
}
