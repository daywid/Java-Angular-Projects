import { HttpClient } from '@angular/common/http';
import { Login } from '../models';
import { Observable } from 'rxjs';
import { environment as env } from 'src/environments/environment.development';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})

export class LoginService {

  private readonly PATH: string = 'auth';


  constructor(private http: HttpClient) {  }

  logar(login: Login): Observable<any>{
    return this.http.post(env.baseUrl + this.PATH, login);
  }


}
