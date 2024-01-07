import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { DisplayComponent } from './display/display.component';
import { ProjetoInputComponent } from './projeto-input/projeto-input.component';
import { EmpacotadorComponent } from './empacotador/empacotador.component';
import { ProjetoEditComponent } from './projeto-edit/projeto-edit.component';
import {MatSelectModule} from '@angular/material/select';
@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    DisplayComponent,
    ProjetoInputComponent,
    EmpacotadorComponent,
    ProjetoEditComponent,
    MatSelectModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
