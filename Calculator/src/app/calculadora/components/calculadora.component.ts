import { Component, OnInit } from '@angular/core';
import { CalculadoraService } from '../services';

@Component({
  selector: 'app-calculadora',
  templateUrl: './calculadora.component.html',
  styleUrl: './calculadora.component.css'
})
export class CalculadoraComponent implements OnInit{

  constructor(private calculadoraService: CalculadoraService) {  }


  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }


}
