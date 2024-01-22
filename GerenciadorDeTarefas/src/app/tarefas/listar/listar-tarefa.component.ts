import { Tarefa } from '../shared';
import { TarefaService } from './../shared/tarefa.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-listar-tarefa',
  templateUrl: './listar-tarefa.component.html',
  styleUrl: './listar-tarefa.component.css'
})
export class ListarTarefaComponent implements OnInit{

  tarefas: Tarefa[];

  constructor(private tarefaService: TarefaService){}

  ngOnInit(): void {
      this.tarefas = this.listarTodos();
      this.tarefas = [
        new Tarefa(1, "Tarefa 1", false),
        new Tarefa(2, "Tarefa 2", true)
      ]
  }

  listarTodos(): Tarefa[] {
    return this.tarefaService.listarTodos();
  }

  remover($event: any, tarefa: Tarefa):void {
    $event.preventDefault();
    if(confirm('deseja remover a tarefa " '+ tarefa.nome + '"?'))
    this.tarefaService.remover(tarefa.id);
    this.tarefas = this.tarefaService.listarTodos();
  }

  alterarStatus(_t12: Tarefa) {
    throw new Error('Method not implemented.');
  }

}
