import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { CandidateService } from '../../services/candidate.service';

@Component({
  selector: 'app-candidate-dashboard',
  standalone: false,
  templateUrl: './candidate-dashboard.component.html',
  styleUrl: './candidate-dashboard.component.css'
})
export class CandidateDashboardComponent implements OnInit {
  profileForm!: FormGroup;
  constructor(private fb: FormBuilder,private candidate:CandidateService) { }
  candidateEmail:any;
  candidateName:any;
  candidateNumber:any;
  
  ngOnInit(): void {
    this.getDetails();
    
    this.profileForm = this.fb.group({
      fullName: [this.candidateName],
      email: [this.candidateEmail],
      mobile: [this.candidateNumber],
      location: [''],
      linkedinUrl: [''],
      githubUrl: [''],
      skills: [''],
      experienceInYears: [''],
      education: ['']
    });
  }

  onSubmit() {

  }
  onFileSelected($event: any) {

  }

  getDetails(){
    this.candidate.getDetailsOfCandidate(localStorage.getItem('email')).subscribe((data:any)=>{
      this.candidateName = data.fullName
      this.candidateEmail = data.email
      this.candidateNumber = data.mobile;
      this.profileForm.patchValue({
          fullName: data.fullName,
          email: data.email,
          mobile: data.mobile,
          location: data.location,
          linkedinUrl: data.linkedinUrl,
          githubUrl: data.githubUrl,
          skills: data.skills,
          experienceInYears: data.experienceInYears,
          education: data.education
        });
    })
  }


}
