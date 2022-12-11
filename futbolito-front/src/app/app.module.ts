import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule} from '@angular/common/http'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PerfilModule } from './modules/perfil/perfil.module';
import { HomeComponent } from './home/home.component';
import { FormsModule } from '@angular/forms';
import { interceptorProvider } from './interceptors/token-intepcetor.service';
import { TeamsModule } from './modules/teams/teams.module';
import { HeaderModule } from './modules/header/header.module';
import { NotificationsModule } from './modules/notifications/notifications.module';
import { AutenticacionModule } from './modules/autenticacion/autenticacion.module';

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
    FormsModule,
    TeamsModule,
    HeaderModule,
    NotificationsModule
  ],
  providers: [interceptorProvider],
  bootstrap: [AppComponent]
})
export class AppModule { }
