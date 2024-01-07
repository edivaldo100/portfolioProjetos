import { Component, Input, Output, EventEmitter, ViewChild } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { NgForm, FormsModule} from '@angular/forms';
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
import { MatSelect } from '@angular/material/select';

import {NgFor} from '@angular/common';

interface Food {
  value: string;
  viewValue: string;
}

@Component({
  selector: 'app-projeto-input',
  templateUrl: './projeto-input.component.html',
  styleUrls: ['./projeto-input.component.css'],
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
            MatRadioModule,
            NgFor],
})
export class ProjetoInputComponent {
  @ViewChild('projetoForm') projetoForm!: NgForm;

  @Output() newDataEvent = new EventEmitter();

  constructor(private http: HttpClient) {}
  funcionarioSelecionado: string = "";
  funcionarios: Funcionario[] = [];

  ngOnInit(): void {
    this.http.get<Funcionario[]>(
      "http://localhost:8080/pessoa/funcionarios"
    ).subscribe(data => this.funcionarios = data);
  }

  onSubmit(): void {
    this.http.post<Projeto>(
      "http://localhost:8080/projetos",
      this.projetoForm.value
    ).subscribe(data => {
      this.newDataEvent.emit(data);
      });

      window.location.reload();
  }

  changeAction(f: any) {
    console.log(f);
    console.log(f);
  }

}
