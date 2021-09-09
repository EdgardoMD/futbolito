import { Injectable } from '@angular/core';



const TOKEN_KEY = "AuthToken";
const USERNAME_KEY = 'AuthUserName';
const AUTHORITIES_KEY = 'AuthAU';



@Injectable({
  providedIn: 'root'
})
export class TokenService {

  roles: Array<string> =[];

  constructor() { }

  public setToken(token: string): void{
    window.sessionStorage.removeItem(TOKEN_KEY);
    window.sessionStorage.setItem(TOKEN_KEY, token);
  }

  public getToken(): string{
    return sessionStorage.getItem(TOKEN_KEY) as string;
  }

  public setUserName(userName: string): void{
    window.sessionStorage.removeItem(USERNAME_KEY);
    window.sessionStorage.setItem(USERNAME_KEY, userName);
  }

  public getUserName(): string{
    return sessionStorage.getItem(USERNAME_KEY) as string;
  }

  public setAuthorities(authorities: string[]): void{
    window.sessionStorage.removeItem(AUTHORITIES_KEY);
    console.log(JSON.stringify(authorities))
    window.sessionStorage.setItem(AUTHORITIES_KEY, JSON.stringify(authorities));
  }

  public getAuthorities(): string[]{
    this.roles = [];
    console.log('entro a get usuario')
    if(sessionStorage.getItem(AUTHORITIES_KEY)){
      console.log('entro al if')
      JSON.parse(sessionStorage.getItem(AUTHORITIES_KEY) as string).forEach((authority: { authority: string; }) => {
        console.log('autorizacion' + authority.authority)
        this.roles.push(authority.authority)
        
      });
    }
    return this.roles;
  }

  public logOut(): void {
    window.sessionStorage.clear();
  }



}
