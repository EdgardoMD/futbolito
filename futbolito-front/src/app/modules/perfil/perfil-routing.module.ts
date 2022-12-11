import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { GuardGuard } from 'src/app/guards/guard.guard';
import { PerfilComponent } from './components/perfil/perfil.component';

const routes: Routes = [
  {
    path: 'perfil',
    canActivate: [ GuardGuard],
    component: PerfilComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PerfilRoutingModule { }
