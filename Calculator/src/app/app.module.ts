import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CalculadoraModule } from './calculadora/calculadora.module';
import { CalculadoraService } from './calculadora/services/calculadora.service';


@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    CalculadoraModule,
  ],
  providers: [
    provideClientHydration(),
    CalculadoraService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
