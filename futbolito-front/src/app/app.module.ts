import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule} from '@angular/common/http'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './component/header/header.component';
import { PerfilModule } from './perfil/perfil.module';
import { HomeComponent } from './home/home.component';
import { AutenticacionModule } from './autenticacion/autenticacion.module';
import { FormsModule } from '@angular/forms';
import { interceptorProvider } from './interceptors/token-intepcetor.service';
import { TeamsModule } from './modules/teams/teams.module';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    PerfilModule,
    AutenticacionModule,
    FormsModule,
    TeamsModule
  ],
  providers: [interceptorProvider],
  bootstrap: [AppComponent]
})
export class AppModule { }
