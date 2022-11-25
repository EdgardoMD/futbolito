import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest, HTTP_INTERCEPTORS } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { TokenService } from '../autenticacion/services/token.service';

@Injectable({
  providedIn: 'root'
})
export class TokenIntepcetorService implements HttpInterceptor{

  constructor(
    private tokenService: TokenService
  ) { }
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    let reqInt = req;
    const token = this.tokenService.getToken();
    if(token != null){
      reqInt =req.clone({
        headers: req.headers.set('Authorization', 'Bearer ' + token)
      });
    }
    return next.handle(reqInt);
  }

}

export const interceptorProvider = [{provide: HTTP_INTERCEPTORS, useClass: TokenIntepcetorService, multi: true}];
