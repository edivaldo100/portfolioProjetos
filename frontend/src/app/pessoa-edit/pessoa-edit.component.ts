import { Component, Input, Output, EventEmitter, ViewChild } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {FormsModule } from '@angular/forms';
import {MatButtonModule} from '@angular/material/button';
import {MatCardModule} from '@angular/material/card';
import {MatCheckboxModule} from '@angular/material/checkbox';
import {MatDividerModule} from '@angular/material/divider';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatIconModule} from '@angular/material/icon';
import {MatInputModule} from '@angular/material/input';
import {MatRadioModule} from '@angular/material/radio';
import {MatSelectModule} from '@angular/material/select';
import { Projeto } from '../Projeto';
import { Funcionario } from '../Funcionario';
import {NgFor} from '@angular/common';

@Component({
  selector: 'app-pessoa-edit',
  templateUrl: './pessoa-edit.component.html',
  styleUrls: ['./pessoa-edit.component.css']
  ,
  standalone: true,
  imports: [MatFormFieldModule,
            MatInputModule,
            MatSelectModule,
            MatButtonModule,
            MatDividerModule,
            MatIconModule,
            FormsModule,
            MatCardModule,
            MatCheckboxModule,
            MatRadioModule,NgFor],
})
export class PessoaEditComponent {

  @Input() funcionario: Funcionario = new Funcionario(0, "", new Date(), "", true);

  @Output() editDataEvent = new EventEmitter();
 
  constructor(
    private http: HttpClient) {}

    ngOnInit(): void {
      
    }

  onSubmit(): void {
    this.http.put<Projeto>(
      "http://localhost:8080/pessoa/"+this.funcionario.id,
      this.funcionario
    ).subscribe(data => {
      this.editDataEvent.emit(data);
      });
      this.reseta()
  }

  reseta(){
    window.location.reload();
  }
  
}
