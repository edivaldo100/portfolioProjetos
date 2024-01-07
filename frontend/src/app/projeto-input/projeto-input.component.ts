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
            MatRadioModule],
})
export class ProjetoInputComponent {
  @ViewChild('projetoForm') projetoForm!: NgForm;

  @Output() newDataEvent = new EventEmitter();

  constructor(private http: HttpClient) {}

  onSubmit(): void {
    this.http.post<Projeto>(
      "http://localhost:8080/projetos",
      this.projetoForm.value
    ).subscribe(data => {
      this.newDataEvent.emit(data);
      });
  }
}
