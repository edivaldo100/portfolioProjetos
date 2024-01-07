import { Component, Input, Output, EventEmitter } from '@angular/core';
 import { CommonModule } from '@angular/common';
import { Projeto } from '../Projeto';
import { DisplayComponent } from '../display/display.component';
import { ProjetoEditComponent } from '../projeto-edit/projeto-edit.component';
@Component({
  selector: 'app-empacotador',
  templateUrl: './empacotador.component.html',
  styleUrls: ['./empacotador.component.css'],
  standalone: true,
  imports: [DisplayComponent, ProjetoEditComponent, CommonModule]
})
export class EmpacotadorComponent {

  @Input() projeto: Projeto = new Projeto(0, "", new Date(), new Date(), new Date(), "", "","","",0);

  @Output() removeItemEvent = new EventEmitter();
  editable: boolean = false;

  handleEditClick(): void {
    this.editable = true;
  }

  handleSaveEdition(projeto: Projeto): void {
    this.editable = false
    this.projeto = projeto;
  }

}
