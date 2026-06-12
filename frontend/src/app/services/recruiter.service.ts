import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class RecruiterService {
  baseUrl:string = "http://localhost:8765/api/jobs";
  constructor(private http:HttpClient) { }
  createJob(payload:any){

  return this.http.post(
    this.baseUrl,
    payload,
    {
      responseType:'text'
    }
  );

}
}
