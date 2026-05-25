import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  standalone: false,
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent implements OnInit {
  registerForm!:FormGroup
  constructor(private fb:FormBuilder,private auth:AuthService,private router:Router){}
  ngOnInit(): void {
    this.registerForm = this.fb.group({
      name:['',Validators.required],
      email:['',Validators.email],
      password:['',Validators.required],
      mobile:['',Validators.required],
      role:['CANDIDATE',Validators.required]

    })
  }
  onSubmit(){
    if(this.registerForm.valid){
      console.log(this.registerForm.value)
      this.auth.register(this.registerForm.value).subscribe({
        next:(res:string)=>{
         console.log(res);
          this.router.navigate(['/login']);
        },
        error:(err:any)=>{
          console.error(err);

        }

        }
      )
  
  }
  }
}