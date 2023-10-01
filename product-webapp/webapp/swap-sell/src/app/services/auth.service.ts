import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private httpClient : HttpClient) { }
  URL = "http://localhost:8080";
  isLoggedIn : boolean = false;
  jwt:string="";
  message:string=""

  getStatus():Observable<boolean>{
    return of(this.isLoggedIn);
  }
}
