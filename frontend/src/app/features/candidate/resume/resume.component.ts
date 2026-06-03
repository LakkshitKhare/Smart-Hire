import { Component, OnInit } from '@angular/core';
import { CandidateService } from '../../../services/candidate.service';
@Component({
  selector: 'app-my-resumes',
  standalone: false,
  templateUrl: './resume.component.html',
  styleUrls: ['./resume.component.css']
})
export class ResumeComponent
implements OnInit {

  resumes:any[] = [];

  selectedFile!: File;

  dragging:boolean = false;

  constructor(
    private candidate:CandidateService
  ){}

  ngOnInit(): void {

    this.loadResumes();

  }

  loadResumes(){

    const email =
      localStorage.getItem('email');

    this.candidate
      .getMyResumes(email)
      .subscribe((data:any)=>{

        this.resumes = data;

      });

  }

  onFileSelected(event:any){

    this.selectedFile =
      event.target.files[0];

  }

  onDrop(event:any){

    event.preventDefault();

    this.dragging = false;

    this.selectedFile =
      event.dataTransfer.files[0];

  }

  onDragOver(event:any){

    event.preventDefault();

    this.dragging = true;

  }

  onDragLeave(){

    this.dragging = false;

  }

  uploadResume(){

    if(!this.selectedFile){
      return;
    }

    const email =
      localStorage.getItem('email');

    this.candidate
      .uploadResume(
        this.selectedFile,
        email!
      )
      .subscribe({

        next:(data:any)=>{

          alert(data);

          this.loadResumes();

        },

        error:(err)=>{

          console.log(err);

        }

      });

  }

  deleteResume(resumeId:any){

    this.candidate
      .deleteResume(resumeId)
      .subscribe({

        next:(data:any)=>{

          alert(data);

          this.loadResumes();

        },

        error:(err)=>{

          console.log(err);

        }

      });

  }

}