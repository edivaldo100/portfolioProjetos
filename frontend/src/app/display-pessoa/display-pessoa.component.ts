import { Component, Input, Output, EventEmitter } from '@angular/core';
import {MatButtonModule} from '@angular/material/button';
import {MatCardModule} from '@angular/material/card';
import { Projeto } from '../Projeto';
import { Funcionario } from '../Funcionario';
import { HttpClient } from '@angular/common/http';
@Component({
  selector: 'app-display-pessoa',
  templateUrl: './display-pessoa.component.html',
  styleUrls: ['./display-pessoa.component.css']
  ,
  standalone: true,
  imports: [MatCardModule, MatButtonModule],
})
export class DisplayPessoaComponent {
  @Input() funcionario: Funcionario = new Funcionario(0, "", new Date(), "", true);

   projeto: Projeto = new Projeto(0, "", new Date(), new Date(), new Date(), "", "","","",0);

  @Output() removeItemEvent = new EventEmitter();
  @Output() editItemEvent = new EventEmitter();
  constructor(private http: HttpClient) {}
}
