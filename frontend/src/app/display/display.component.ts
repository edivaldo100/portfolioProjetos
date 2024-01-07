import { Component, Input, Output, EventEmitter } from '@angular/core';
import {MatButtonModule} from '@angular/material/button';
import {MatCardModule} from '@angular/material/card';
import { Projeto } from '../Projeto';
import { Funcionario } from '../Funcionario';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-display',
  templateUrl: './display.component.html',
  styleUrls: ['./display.component.css']
  ,
  standalone: true,
  imports: [MatCardModule, MatButtonModule],
})
export class DisplayComponent {
  funcionario: Funcionario = new Funcionario(0, "", new Date(), "", true);

  @Input() projeto: Projeto = new Projeto(0, "", new Date(), new Date(), new Date(), "", "","","",0);

  @Output() removeItemEvent = new EventEmitter();
  @Output() editItemEvent = new EventEmitter();
  constructor(private http: HttpClient) {}
  ngOnInit(): void {
   // this.http.get<Funcionario>(
   //   "http://localhost:8080/pessoa/"+this.projeto.idGerente
   // ).subscribe(data => {
   //   this.funcionario = data
  //  console.log(this.funcionario)
  //  console.log(this.funcionario)
  //    }
   //   );

  //  this.projeto.gerente = this.funcionario.nome;
  }

}
