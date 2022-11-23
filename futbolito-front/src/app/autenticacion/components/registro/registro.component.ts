import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginUsuario } from '../../models/login-usuario';
import { NewUser } from '../../models/new-user';
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
  newUser: NewUser = {};
  name: string = '';
  lastName: string = '';
  nickname: string = '';
  phone: string = '';
  email: string = '';
  password: string = '';
  confirmationPassword: string = '';

  constructor(
    private tokenService: TokenService,
    private autenticacionService: AutenticacionService,
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  onRegister(): void{
    console.log("entro a register")
    this.newUser = new NewUser(this.name, this.lastName, this.nickname, this.phone,
      this.email, this.password, this.confirmationPassword);
      this.autenticacionService.nuevoUsuario(this.newUser).subscribe(
        data => {
          
        }
      )

  }

}
