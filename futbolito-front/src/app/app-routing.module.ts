import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './modules/home/componets/home/home.component';
import { ListMyTeamsComponent } from './modules/teams/components/list-my-teams/list-my-teams.component';
import { NewTeamComponent } from './modules/teams/components/new-team/new-team.component';
import { MyTeamComponent } from './modules/teams/components/my-team/my-team.component';
import { NotificationsComponent } from './modules/notifications/components/notifications/notifications.component';
import { GuardGuard } from './guards/guard.guard';
import { RegistroComponent } from './modules/autenticacion/components/registro/registro.component';
import { LoginComponent } from './modules/autenticacion/components/login/login.component';

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
    canActivate: [ GuardGuard],
    component: ListMyTeamsComponent
  },
  {
    path: 'new-team',
    canActivate: [ GuardGuard],
    component: NewTeamComponent
  },
  {
    path: 'my-team',
    canActivate: [ GuardGuard],
    component: MyTeamComponent
  },
  {
    path: 'notifications',
    canActivate: [ GuardGuard],
    component: NotificationsComponent
  }




  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
