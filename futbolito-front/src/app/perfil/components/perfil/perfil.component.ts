import { Component, OnInit } from '@angular/core';
import { Perfil } from '../../model/perfil.model';

import {PerfilService} from './../../services/perfil.service'

@Component({
  selector: 'app-perfil',
  templateUrl: './perfil.component.html',
  styleUrls: ['./perfil.component.css']
})
export class PerfilComponent implements OnInit {

  perfil: Perfil = {};

  constructor(
    private perfilService : PerfilService
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
    console.log('mostramos en nuevo metodo')
    console.log(this.perfil)
  }

}
