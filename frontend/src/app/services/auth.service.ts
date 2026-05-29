import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  userUrl:string = "http://localhost:8765/api/users";
  constructor(private http:HttpClient) { }

  register(payload:any){
    return this.http.post(this.userUrl+"/register",payload ,{responseType:'text'});
  }
  login(payload:any){
    return this.http.post(this.userUrl+"/login",payload,{responseType:'text'});
  }
}
