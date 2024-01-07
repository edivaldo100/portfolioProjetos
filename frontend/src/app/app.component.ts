import { Component } from "@angular/core";
import { HttpClient } from '@angular/common/http';

import { Projeto } from "./Projeto";

@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.css"],
})
export class AppComponent {

  projetos: Projeto[] = [];

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    this.http.get<Projeto[]>(
      "http://localhost:8080/projetos"
    ).subscribe(data => this.projetos = data);
  }

  appendData(novoProjeto: any): void {
    this.projetos.push(novoProjeto);
  }

  removeItem(projetosId: number): void {
    this.http.delete(
      "http://localhost:8080/projetos/" + projetosId,
    ).subscribe(data => this.projetos = this.projetos.filter((projeto: Projeto) => projeto.id != projetosId));
  }

}
