import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { RecruiterService } from '../../../services/recruiter.service';

@Component({
  selector: 'app-create-job',
  standalone: false,
  templateUrl: './create-job.component.html',
  styleUrls: ['./create-job.component.css']
})
export class CreateJobComponent implements OnInit {

  jobForm!: FormGroup;

  constructor(
    private fb: FormBuilder,
    private recruiterService: RecruiterService
  ) {}

  ngOnInit(): void {

    this.jobForm = this.fb.group({

      jobTitle: ['', Validators.required],

      location: ['', Validators.required],

      jobType: ['', Validators.required],

      experienceRequired: [0],

      salaryMin: [''],

      salaryMax: [''],

      requiredSkills: [''],

      description: [''],

      vacancies: [1],

      applicationDeadline: ['']

    });

  }

  onSubmit(){

    const payload = {

      ...this.jobForm.value,

      recruiterEmail: localStorage.getItem('email')

    };

    console.log(payload);

    this.recruiterService
      .createJob(payload)
      .subscribe({

        next:(res:any)=>{

          alert(res);

          this.jobForm.reset();

        },

        error:(err)=>{

          console.log(err);

        }

      });

  }

}