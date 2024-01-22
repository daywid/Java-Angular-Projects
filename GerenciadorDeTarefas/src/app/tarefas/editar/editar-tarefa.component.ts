import { Tarefa } from './../shared/tarefa.model';
import { Component, OnInit, ViewChild } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { NgForm } from '@angular/forms';

import { TarefaService } from '../shared';

@Component({
  selector: 'app-editar-tarefa',
  templateUrl: './editar-tarefa.component.html',
  styleUrl: './editar-tarefa.component.css'
})
export class EditarTarefaComponent {

  @ViewChild('formTarefa', { static: true }) formTarefa: NgForm;
  tarefa: Tarefa;

  constructor(
    private TarefaService: TarefaService,
    private route: ActivatedRoute,
    private router: Router
  ){}

  ngOnInit(){
    let id = +this.route.snapshot.params['id'];
    this.tarefa = this.TarefaService.buscarPorId(id);
  }

  atualizar(): void {
    if (this.formTarefa.form.valid) {
	    this.TarefaService.atualizar(this.tarefa);
	    this.router.navigate(['/tarefas']);
    }
  }

}
