import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NotificationsService } from 'src/app/services/notifications.service';

@Component({
  selector: 'app-notifications',
  templateUrl: './notifications.component.html',
  styleUrls: ['./notifications.component.css']
})
export class NotificationsComponent implements OnInit {

  objectos: any[] = [];

  constructor(
    private router : Router,
    private notificationsService: NotificationsService
  ) { }

  ngOnInit(): void {
    this.getnotifications();
  }

  getnotifications(){
    this.notificationsService.getNotifications().subscribe(
            notifications => {
              console.log(notifications);
      }
    )
  }

}
