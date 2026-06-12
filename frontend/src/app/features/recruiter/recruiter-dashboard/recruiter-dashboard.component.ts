import { Component } from '@angular/core';

@Component({
  selector: 'app-recruiter-dashboard',
  standalone: false,
  templateUrl: './recruiter-dashboard.component.html',
  styleUrl: './recruiter-dashboard.component.css'
})
export class RecruiterDashboardComponent {
  recruiterName:string = 'HELLO';
}
