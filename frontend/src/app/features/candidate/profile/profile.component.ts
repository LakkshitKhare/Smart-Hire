import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { CandidateService } from '../../../services/candidate.service';

@Component({
  selector: 'app-profile',
  standalone: false,
  templateUrl: './profile.component.html',
  styleUrl: './profile.component.css'
})
export class ProfileComponent implements OnInit {


  profileForm!: FormGroup;

  constructor(
    private fb: FormBuilder,
    private candidate: CandidateService
  ) { }

  ngOnInit(): void {

    this.getDetails();

  }

  getDetails() {

    this.candidate
      .getDetailsOfCandidate(localStorage.getItem('email'))
      .subscribe((data: any) => {

        this.profileForm = this.fb.group({

          fullName: [data.fullName],
          email: [data.email],
          mobile: [data.mobile],
          location: [data.location],
          linkedinUrl: [data.linkedinUrl],
          githubUrl: [data.githubUrl],
          skills: [data.skills],
          experienceInYears: [data.experienceInYears],
          education: [data.education]

        });

      });

  }

  onSubmit() {

    this.candidate
      .saveDetails(this.profileForm.getRawValue())
      .subscribe({

        next: (data: any) => {
          console.log(data);
          alert("Profile Updated Successfully");
        },

        error: (err) => {
          console.log(err);
        }

      });

  }

  onFileSelected(event: any) {

    const file = event.target.files[0];

    console.log(file);

  }

}
