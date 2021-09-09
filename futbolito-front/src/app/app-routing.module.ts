import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { RegistroComponent } from './autenticacion/components/registro/registro.component';
import { LoginComponent } from './autenticacion/components/login/login.component';

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
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
