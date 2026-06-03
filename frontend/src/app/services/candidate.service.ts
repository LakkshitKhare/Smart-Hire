import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CandidateService {

  baseUrl:string = "http://localhost:8765/api/candidate"
  resumeUrl:string = "http://localhost:8765/api/resume"

  constructor(private http:HttpClient) { }

  getDetailsOfCandidate(email:any){
    return this.http.get(this.baseUrl+"/"+email);
  }
  saveDetails(payload:any){
    return this.http.put(this.baseUrl+"/save",payload,{responseType:'text'});
  }
  uploadResume(file:File,email:any){
    const formData = new FormData();
    formData.append('file',file);
    formData.append('email',email);
    return this.http.post(this.resumeUrl+'/upload',formData,{responseType:'text'});
  }
  getMyResumes(email:any){
    return this.http.get(this.resumeUrl+'/my-resumes/'+email)
  }
  deleteResume(resumeId:any){

  return this.http.delete(
    this.resumeUrl + '/' + resumeId,
    {
      responseType:'text'
    }
  );
}
}
