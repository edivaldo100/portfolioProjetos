import { Component } from "@angular/core";
import { HttpClient } from '@angular/common/http';

import { Projeto } from "./Projeto";
import { Funcionario } from "./Funcionario";

@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.css"],
})
export class AppComponent {

  projetos: Projeto[] = [];
  funcionarios: Funcionario[] = [];

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    this.http.get<Projeto[]>(
      "http://localhost:8080/projetos"
    ).subscribe(data => this.projetos = data);

    this.http.get<Funcionario[]>(
      "http://localhost:8080/pessoa"
    ).subscribe(data => this.funcionarios = data);
  }

  appendData(novoProjeto: any): void {
    this.projetos.push(novoProjeto);
  }
  appendDataFunc(novoPessoa: any): void {
    this.funcionarios.push(novoPessoa);
  }

  removeItemFunc(funcId: number): void {
    var resp = this.http.delete(
      "http://localhost:8080/pessoa/" + funcId,
    ).subscribe(
      data => {
        console.log(data);
        this.funcionarios = this.funcionarios.filter((funcionario: Funcionario) => funcionario.id != funcId)
      }, error => {
        console.log("--------ERRO--->");
        console.log(error);
        if(error.error.codigo == 400)
        alert(error.error.mensagem);
        
      }
      );
      console.log(resp);
  }
  

  removeItem(projetosId: number): void {
    this.removeItemService(projetosId);
  }

  removeItemService(projetosId: number): void {
    var resp = this.http.delete(
      "http://localhost:8080/projetos/" + projetosId,
    ).subscribe(
      data => {
        console.log(data);
        this.projetos = this.projetos.filter((projeto: Projeto) => projeto.id != projetosId)
      }, error => {
        console.log("--------ERRO--->");
        console.log(error);
        if(error.error.codigo == 400)
        alert(error.error.mensagem);
        
      }
      );
      console.log(resp);
   
  }
}
