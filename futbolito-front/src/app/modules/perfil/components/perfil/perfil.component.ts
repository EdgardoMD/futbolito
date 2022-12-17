import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Athlete } from '../../../../models/athlete.model';

import {PerfilService} from '../../../../services/perfil.service'

@Component({
  selector: 'app-perfil',
  templateUrl: './perfil.component.html',
  styleUrls: ['./perfil.component.css']
})
export class PerfilComponent implements OnInit {

  perfil: Athlete = {};

  constructor(
    private perfilService : PerfilService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.getPerfil();
  }

  ngDoCheck (){
    this.mostrarPerfil();
  }

  getPerfil(){
    this.perfilService.getPerfil().subscribe( perfil =>{
      this.perfil = perfil;
    })
  }

  mostrarPerfil(){
  }

  logOut(): void {
    window.sessionStorage.clear();
    this.router.navigate(['']);
  }

}
