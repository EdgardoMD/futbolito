import { NgModule } from '@angular/core';
import { HttpClientModule} from '@angular/common/http'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PerfilModule } from './modules/perfil/perfil.module';
import { HomeComponent } from './modules/home/componets/home/home.component';
import { interceptorProvider } from './interceptors/token-intepcetor.service';
import { TeamsModule } from './modules/teams/teams.module';
import { HeaderModule } from './modules/header/header.module';
import { NotificationsModule } from './modules/notifications/notifications.module';
import { AutenticacionModule } from './modules/autenticacion/autenticacion.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BrowserModule } from '@angular/platform-browser';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    PerfilModule,
    AutenticacionModule,
    TeamsModule,
    HeaderModule,
    NotificationsModule,
    BrowserAnimationsModule
  ],
  providers: [interceptorProvider],
  bootstrap: [AppComponent]
})
export class AppModule { }
