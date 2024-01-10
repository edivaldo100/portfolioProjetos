import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { DisplayComponent } from './display/display.component';
import { ProjetoInputComponent } from './projeto-input/projeto-input.component';
import { EmpacotadorComponent } from './empacotador/empacotador.component';
import { ProjetoEditComponent } from './projeto-edit/projeto-edit.component';
import { MatSelectModule} from '@angular/material/select';
import { PessoaInputComponent } from './pessoa-input/pessoa-input.component';
import { DisplayPessoaComponent } from './display-pessoa/display-pessoa.component';
import { EnpacotadorPessoaComponent } from './enpacotador-pessoa/enpacotador-pessoa.component';
import { PessoaEditComponent } from './pessoa-edit/pessoa-edit.component';
@NgModule({
  declarations: [
    AppComponent
    
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    DisplayComponent,
    ProjetoInputComponent,
    EmpacotadorComponent,
    ProjetoEditComponent,
    MatSelectModule,
    PessoaInputComponent,
    DisplayPessoaComponent,
    EnpacotadorPessoaComponent,
    PessoaEditComponent,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
