import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { RegistroComponent } from './autenticacion/components/registro/registro.component';
import { LoginComponent } from './autenticacion/components/login/login.component';
import { ListMyTeamsComponent } from './modules/teams/components/list-my-teams/list-my-teams.component';
import { NewTeamComponent } from './modules/teams/components/new-team/new-team.component';
import { MyTeamComponent } from './modules/teams/components/my-team/my-team.component';
import { NotificationsComponent } from './modules/notifications/components/notifications/notifications.component';

const routes: Routes = [
  {
    path: '',
    component: HomeComponent
  },
  // 
  // para rutas hijas
  // para los modulos
  // {
  //   path: 'login',
  //   loadChildren: () => 
  //   import('./autenticacion/autenticacion.module')
  //   .then(m=>m.AutenticacionModule)
  // },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'registro',
    component: RegistroComponent
  },
  {
    path: 'my-teams',
    component: ListMyTeamsComponent
  },
  {
    path: 'new-team',
    component: NewTeamComponent
  },
  {
    path: 'my-team',
    component: MyTeamComponent
  },
  {
    path: 'notifications',
    component: NotificationsComponent
  }




  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
