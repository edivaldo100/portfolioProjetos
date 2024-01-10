import {Component} from '@angular/core';
import {FormBuilder, FormGroup, Validators, FormsModule, ReactiveFormsModule} from '@angular/forms';
import {MatButtonModule} from '@angular/material/button';
import {
  MatSlideToggleModule,
  _MatSlideToggleRequiredValidatorModule,
} from '@angular/material/slide-toggle';

import { Input, Output, EventEmitter, ViewChild } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { NgForm} from '@angular/forms';

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

@Component({
  selector: 'app-pessoa-input',
  templateUrl: './pessoa-input.component.html',
  styleUrls: ['./pessoa-input.component.css'],
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
            NgFor,
            MatSlideToggleModule,
            _MatSlideToggleRequiredValidatorModule,
            MatButtonModule,
            ReactiveFormsModule],
})
export class PessoaInputComponent {

  constructor(private http: HttpClient, private _formBuilder: FormBuilder) {}
  @ViewChild('pessoaForm') pessoaForm!: NgForm;
  @Output() newDataEvent = new EventEmitter();

  checked = false;
  indeterminate = false;
  labelPosition: 'true' | 'false' = 'true';
  disabled = false;
  radio:any;
  alertFormValues(formGroup: FormGroup) {
    alert(JSON.stringify(formGroup.value, null, 2));
  }

  onSubmit(): void {
    this.http.post<Projeto>(
      "http://localhost:8080/pessoa",
      this.pessoaForm.value
    ).subscribe(data => {
      this.newDataEvent.emit(data);
      });
      window.location.reload();
  }
}
