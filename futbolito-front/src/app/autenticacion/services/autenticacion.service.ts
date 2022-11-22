import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { JWTDTO } from '../models/jwt-dto';
import { LoginUsuario } from '../models/login-usuario';
import { NuevoUsuario } from '../models/nuevo-usuario';

@Injectable({
  providedIn: 'root'
})
export class AutenticacionService {

  authURL: string = 'http://localhost:9999/auth';

  constructor(private httpClient: HttpClient) { }

  public nuevoUsuario(nuevoUsuario: NuevoUsuario): Observable<any>{
    return this.httpClient.post<any>(this.authURL + '/new_user', nuevoUsuario)
  }

  public loginUsuario(loginUsuario: LoginUsuario): Observable<JWTDTO>{
    return this.httpClient.post<any>(this.authURL + '/login', loginUsuario)
  }


}
