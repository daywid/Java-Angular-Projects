import { Tarefa } from './../../../../../GerenciadorDeTarefas/src/app/tarefas/shared/tarefa.model';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class JogoDaVelhaService {

  private readonly TAM_TAB: number = 3;
  private readonly X: number = 1;
  private readonly O: number = 2;
  private readonly VAZIO: number = 0;

  private tabuleiro: any;
  private numMovimentos: number;
  private vitoria: any;

  private _jogador: number;
  private _showInicio: boolean;
  private _showTabuleiro: boolean;
  private _showFinal: boolean;

  constructor() {}

  inicializar():void {
    this._showInicio = true;
    this._showTabuleiro = false;
    this._showFinal = false;
    this.numMovimentos = 0;
    this._jogador = this.X;
    this.vitoria = false;
    this.inicializarTabuleiro();
  }

  inicializarTabuleiro() {
      this.tabuleiro = [this.TAM_TAB];
      for(let i = 0; i < this.TAM_TAB; i++){
        this.tabuleiro[i] = [this.VAZIO, this.VAZIO, this.VAZIO];
      }
  }

  get showInicio(): boolean{
    return this._showInicio;
  }

  get showTabuleiro(): boolean{
    return this.showTabuleiro;
  }

  get showFinal(): boolean {
    return this.showFinal;
  }

  get jogador(): number {
    return this.jogador;
  }

  iniciarJogo():void {
    this._showInicio = false;
    this._showTabuleiro = true;
  }

  jogar(posX: number, posY: number): void{
    if (this.tabuleiro[posX][posY] !== this.VAZIO || this.vitoria ){
      return;
    }

    this.tabuleiro[posX][posY] = this.jogador;
    this.numMovimentos++;
    this.vitoria = this.fimJogo(posX, posY,
    this.tabuleiro, this._jogador);
    this._jogador = (this._jogador === this.X) ? this.O : this.X;

    if(!this.vitoria && this.numMovimentos < 9){
      this.cpuJogar();
    }

  }

  cpuJogar() {
    throw new Error('Method not implemented.');
  }
  fimJogo(posX: number, posY: number, tabuleiro: any, _jogador: number): any {
    throw new Error('Method not implemented.');
  }


}
