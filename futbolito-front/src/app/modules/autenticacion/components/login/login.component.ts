import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AutenticacionService } from '../../../../services/autenticacion.service';
import { LoginUsuario } from 'src/app/models/login-usuario';
import { TokenService } from 'src/app/services/token.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  isLogged: boolean = false;
  isLoginFail : boolean = false;
  loginUsuario: LoginUsuario = {};
  nombreUsuario: string = '';
  password: string = '';
  roles: string[] = [];
  mensajeError: string = '';

  constructor(
    private tokenService: TokenService,
    private autenticacionService: AutenticacionService,
    private router: Router
  ) { }

  ngOnInit(): void {
    if(this.tokenService.getToken()){
      this.isLogged = true;
      this.isLoginFail = false;
      this.roles = this.tokenService.getAuthorities();
    }
  }

  onLogin(): void {
    console.log("entro a on login")
    this.loginUsuario = new LoginUsuario(this.nombreUsuario, this.password)
    this.autenticacionService.loginUsuario(this.loginUsuario).subscribe(
      data => {
        this.isLogged = true;
        this.isLoginFail = false;
        this.tokenService.setToken(data.token as string);
        this.tokenService.setUserName(data.username as string);
        this.tokenService.setAuthorities(data.authorities as string[]);
        this.roles = data.authorities as string [];
        this.router.navigate(['perfil']);
      },
      error => {
        this.isLogged = false;
        this.isLoginFail = true;
        this.mensajeError = error.error.mensaje;
        console.log(this.mensajeError);
      }
    )
  }

  logOut():void{
    this.isLogged = false;
    this.loginUsuario = {};
    this.nombreUsuario = '';
    this.password = '';
    this.roles = [];
    this.tokenService.logOut();
  }


}
