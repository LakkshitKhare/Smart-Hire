import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: false,
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnInit {
  loginForm!:FormGroup;
  constructor(private fb:FormBuilder,private auth:AuthService,private router:Router){}
  ngOnInit(): void {
    this.loginForm = this.fb.group({
      email:['',[Validators.required,Validators.email]],
      password:['',Validators.required]
    });
  }
  onSubmit(){
    this.auth.login(this.loginForm.value).subscribe({
      next:(res:any)=>{
        if(res == 'CANDIDATE'){
        this.router.navigate(['/candidate']);
        }
        else if(res=='RECRUITER'){
          this.router.navigate(['/recruiter']);
        }
        localStorage.setItem('email',this.loginForm.value.email)
      },
      error:(err:any)=>{
        console.error(err);
      }
    })
  }
}
