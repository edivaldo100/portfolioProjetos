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
@Component({
  selector: 'app-projeto-edit',
  templateUrl: './projeto-edit.component.html',
  styleUrls: ['./projeto-edit.component.css'],
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
export class ProjetoEditComponent {
  @Input() projeto: Projeto = new Projeto(0, "", new Date(), new Date(), new Date(), "", "","","",0);

  @Output() editDataEvent = new EventEmitter();

  constructor(
    private http: HttpClient) {}

  onSubmit(): void {
    this.http.put<Projeto>(
      "http://localhost:8080/projetos/"+this.projeto.id,
      this.projeto
    ).subscribe(data => {
      this.editDataEvent.emit(data);
      });

      //this.router.navigate('http://localhost:4200');
      //this.router.navigateByUrl('http://localhost:4200');
      //this.router.navigate(['http://localhost:4200'])

      this.reseta()
  }

  reseta(){
    window.location.reload();
  }
}
