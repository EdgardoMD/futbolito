import { Component, OnInit } from '@angular/core';
import { MatSnackBar, MatSnackBarHorizontalPosition, MatSnackBarVerticalPosition } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { NewUser } from 'src/app/models/new-user';
import { AutenticacionService } from '../../../../services/autenticacion.service';

  


@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.css']
})
export class RegistroComponent implements OnInit {

  horizontalPosition: MatSnackBarHorizontalPosition = 'start';
  verticalPosition: MatSnackBarVerticalPosition = 'bottom';

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
  minNick: boolean = false;

  constructor(
    private autenticacionService: AutenticacionService,
    private router: Router,
    private _snackBar: MatSnackBar,
  ) { }

  ngOnInit(): void {
  }

  onRegister(): void{
    if(this.nickname.length < 5){
      this.minNick = true;
      return; 
   } else {
    this.newUser = new NewUser(this.name, this.lastName, this.nickname, this.phone,
      this.email, this.password, this.confirmationPassword);
      this.autenticacionService.nuevoUsuario(this.newUser).subscribe(
        data => {
          this.router.navigate(['perfil']);
          this.openSnackBar("perfil creado con exito")
        }, err => {
          console.log(err);
          this.openSnackBar("error creando el perfil = " + err.error.message)
        }
      )
   }
    

  }


  openSnackBar(message : string) {
    this._snackBar.open(message, '', {
      duration:  3000,
      horizontalPosition: this.horizontalPosition,
      verticalPosition: this.verticalPosition,
    });
  }

}


