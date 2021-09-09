import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginUsuario } from '../../models/login-usuario';
import { AutenticacionService } from '../../services/autenticacion.service';
import { TokenService } from '../../services/token.service';

@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.css']
})
export class RegistroComponent implements OnInit {

  isLogged: boolean = false;
  isLoginFail : boolean = false;
  loginUsuario: LoginUsuario = {};
  nombreUsuario: string = '';
  password: string = '';

  constructor(
    private tokenService: TokenService,
    private autenticacionService: AutenticacionService,
    private router: Router
  ) { }

  ngOnInit(): void {
  }

}
