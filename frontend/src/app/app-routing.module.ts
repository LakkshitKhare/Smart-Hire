import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { LoginComponent } from './auth/login/login.component';
import { RegisterComponent } from './auth/register/register.component';

import { CandidateDashboardComponent } from './features/candidate/candidate-dashboard/candidate-dashboard.component';

import { LayoutComponent } from './features/candidate/layout/layout.component';

import { ProfileComponent } from './features/candidate/profile/profile.component';

const routes: Routes = [

  // AUTH
  {
    path: '',
    component: LoginComponent
  },

  {
    path: 'login',
    component: LoginComponent
  },

  {
    path: 'register',
    component: RegisterComponent
  },
  {
    path: 'candidate',
    component: LayoutComponent,

    children: [

      {
        path: 'dashboard',
        component: CandidateDashboardComponent
      },

      {
        path: 'profile',
        component: ProfileComponent
      },
      {
        path: '',
        redirectTo: 'dashboard',
        pathMatch: 'full'
      }

    ]
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }