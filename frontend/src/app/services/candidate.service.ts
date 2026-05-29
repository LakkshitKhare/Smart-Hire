import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CandidateService {

  baseUrl:string = "http://localhost:8765/api/candidate"

  constructor(private http:HttpClient) { }

  getDetailsOfCandidate(email:any){
    return this.http.get(this.baseUrl+"/"+email);
  }
}
