import { Component, Input, Output, EventEmitter } from '@angular/core';
import {MatButtonModule} from '@angular/material/button';
import {MatCardModule} from '@angular/material/card';
import { Projeto } from '../Projeto';



@Component({
  selector: 'app-display',
  templateUrl: './display.component.html',
  styleUrls: ['./display.component.css']
  ,
  standalone: true,
  imports: [MatCardModule, MatButtonModule],
})
export class DisplayComponent {

  @Input() projeto: Projeto = new Projeto(0, "", new Date(), new Date(), new Date(), "", "","","",0);

  @Output() removeItemEvent = new EventEmitter();
  @Output() editItemEvent = new EventEmitter();
}
