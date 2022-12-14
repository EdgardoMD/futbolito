import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class InvitationService {

  invitationURL: string = environment.apiUrl + '/invitation';

  constructor(private httpClient: HttpClient) { }




  public createdInvitationMyTeam(idTeam :number, idGuest:number) : Observable<boolean>{
    let body: any = {'idTeam' :idTeam, 'idGuest': idGuest};
    return this.httpClient.post<boolean>(this.invitationURL + '/created-invitation', body);
  }
}
