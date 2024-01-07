import { Pipe, PipeTransform } from '@angular/core';
import { Projeto } from './Projeto';


@Pipe({
  name: 'order'
})
export class OrderPipe implements PipeTransform {

  transform(list: Projeto[], params: string): Projeto[] {
    if(params.length){
      return list.sort((a,b) => a.nome.localeCompare(b.nome));
    }
    return list;
  }

}
