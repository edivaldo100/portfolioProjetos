import { Component, Input, Output, EventEmitter } from '@angular/core';
 import { CommonModule } from '@angular/common';
import { Projeto } from '../Projeto';
import { DisplayComponent } from '../display/display.component';
import { ProjetoEditComponent } from '../projeto-edit/projeto-edit.component';
import { Funcionario } from '../Funcionario';
import { DisplayPessoaComponent } from '../display-pessoa/display-pessoa.component';
import { PessoaEditComponent } from '../pessoa-edit/pessoa-edit.component';
@Component({
  selector: 'app-enpacotador-pessoa',
  templateUrl: './enpacotador-pessoa.component.html',
  styleUrls: ['./enpacotador-pessoa.component.css'],
  standalone: true,
  imports: [DisplayPessoaComponent,
    PessoaEditComponent, CommonModule]
})
export class EnpacotadorPessoaComponent {

  @Input() funcionario: Funcionario = new Funcionario(0, "", new Date(), "", true);

  @Output() removeItemEvent = new EventEmitter();
  editable: boolean = false;

  handleEditClick(): void {
    this.editable = true;
  }

  handleSaveEdition(funcionario: Funcionario): void {
    this.editable = false
    this.funcionario = funcionario;
  }

}
