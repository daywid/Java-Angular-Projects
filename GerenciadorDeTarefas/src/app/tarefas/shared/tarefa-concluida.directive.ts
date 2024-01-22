// import { TarefaConcluidaDirective } from './tarefa-concluida.directive';
import { Directive, ElementRef, Input, OnInit, input } from '@angular/core';

@Directive({
  selector: '[tarefaConcluida]'
})
export class TarefaConcluidaDirective implements OnInit{

  @Input() tarefaConcluida: boolean;

  constructor(private el: ElementRef) { }

  ngOnInit(){
    if (this.tarefaConcluida){
      this.el.nativeElement.style.textDecoration = "Line-through"
    }
  }

}
