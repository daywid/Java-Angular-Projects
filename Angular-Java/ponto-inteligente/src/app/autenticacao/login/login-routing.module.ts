import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginComponent } from './components/login/login.component';
import { LogarComponent } from './components';
import { RouterModule, Routes } from '@angular/router';

export const LoginRoutes: Routes = [
  {
      path: 'login',
      component: LogarComponent,
      children: [{path: '', component: LoginComponent }]
  }
];


@NgModule({
  declarations: [
    LoginComponent
  ],
  imports: [
    CommonModule,
    RouterModule.forChild(LoginRoutes)
  ],
  exports: [
    RouterModule
  ]
})


export class LoginRoutingModule {
}
