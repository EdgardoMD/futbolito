import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Notification } from 'src/app/models/notification.model';

@Injectable({
  providedIn: 'root'
})
export class NotificationsService {

  teamsURL: string = environment.apiUrl + '/notifications';

  constructor(private httpClient: HttpClient) { }


  public getNotifications() : Observable<Notification[]>{
    return this.httpClient.get<Notification[]>(this.teamsURL )
  }
}
