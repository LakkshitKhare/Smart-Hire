import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { CandidateService } from '../../../services/candidate.service';

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
    
    
  }

}
