import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-candidate-dashboard',
  standalone: false,
  templateUrl: './candidate-dashboard.component.html',
  styleUrl: './candidate-dashboard.component.css'
})
export class CandidateDashboardComponent implements OnInit {
  profileForm!: FormGroup;
  constructor(private fb: FormBuilder) { }
  ngOnInit(): void {
    this.profileForm = this.fb.group({
      fullName: [''],
      email: [''],
      mobile: [''],
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
}
