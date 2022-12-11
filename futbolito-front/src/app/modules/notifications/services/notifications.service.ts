import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class NotificationsService {

  teamsURL: string = environment.apiUrl + '/notifications';

  constructor(private httpClient: HttpClient) { }


  public getNotifications() : Observable<any[]>{
    return this.httpClient.get<any[]>(this.teamsURL )
  }
}
