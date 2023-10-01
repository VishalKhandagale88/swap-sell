import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, map, of } from 'rxjs';
import { User } from '../modals/User';

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

  login(user:User):Observable<boolean>{
    return this.httpClient.post(this.URL+"/login",user).pipe(map(data=>{
      console.log(data);
      let json = JSON.stringify(data);
      this.jwt= JSON.parse(json).token;
      this.message = JSON.parse(json).email;
      let email = JSON.parse(json).email;

      console.log(this.jwt,this.message);

      sessionStorage.setItem("jwt",this.jwt);
      sessionStorage.setItem("message",this.message);
      if(this.message === "Login Successful"){
        this.isLoggedIn = true;

        // featch user data here

      }else{
        this.isLoggedIn=false
      }
      return this.isLoggedIn;
    }))
  }
}
