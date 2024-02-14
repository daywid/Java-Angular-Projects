import { LoginService } from './../../services/login.service';
import { Component, OnInit } from '@angular/core';
import { Form, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar'

import { Login } from '../../models';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnInit{

  form: FormGroup;

  constructor(
    private fb: FormBuilder,
    private snackbar :MatSnackBar,
    private router: Router,
    private LoginService: LoginService){}

  ngOnInit(): void {
    this.gerarForm();
  }

  gerarForm(){
    this.form = this.fb.group({

      email: ['', [Validators.required, Validators.email]],
      senha: ['', [Validators.required, Validators.minLength(6)] ]
    });
  }

  // logar(){
  //   if (this.form.invalid){
  //     this.snackbar.open(
  //       "Dados inválidos", "Erro", {duration:5000});
  //       return;
  //   }
  //   const login: Login = this.form.value;
  //   alert('Email' + login.email + ', senha' + login.senha);
  // }

  logar() {
    if (this.form.invalid) {
      return;
    }

    const login: Login = this.form.value;
    this.LoginService.logar(login)
      .subscribe(
        data => {
          console.log(JSON.stringify(data));
          localStorage['token'] = data['data']['token'];
          const usuarioData = JSON.parse(atob(data['data']['token'].split('.')[1]));
          console.log(JSON.stringify(usuarioData));

          if (usuarioData['role'] == 'ROLE_ADMIN') {
            alert('Deve redirecionar para a página de admin');
            // this.router.navigate(['/admin']);
          } else {
            alert('Deve redirecionar para a página de funcionário');
            // this.router.navigate(['/funcionario']);
          }
        },
        error => {
          console.error('Erro ao tentar logar:', error);
          // Adicione a lógica de tratamento de erro, se necessário.
        }
      );
  }


}
