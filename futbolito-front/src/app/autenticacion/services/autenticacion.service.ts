import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { JWTDTO } from '../../models/jwt-dto';
import { environment } from 'src/environments/environment';
import { NewUser } from 'src/app/models/new-user';
import { LoginUsuario } from 'src/app/models/login-usuario';

@Injectable({
  providedIn: 'root'
})
export class AutenticacionService {

  authURL: string = environment.apiUrl + '/auth';

  constructor(private httpClient: HttpClient) { }

  public nuevoUsuario(newUser: NewUser): Observable<String>{
    return this.httpClient.post<any>(this.authURL + '/new_user', newUser)
  }

  public loginUsuario(loginUsuario: LoginUsuario): Observable<JWTDTO>{
    return this.httpClient.post<any>(this.authURL + '/login', loginUsuario)
  }


}
