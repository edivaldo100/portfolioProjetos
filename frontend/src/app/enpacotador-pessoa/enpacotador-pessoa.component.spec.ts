import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EnpacotadorPessoaComponent } from './enpacotador-pessoa.component';

describe('EnpacotadorPessoaComponent', () => {
  let component: EnpacotadorPessoaComponent;
  let fixture: ComponentFixture<EnpacotadorPessoaComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [EnpacotadorPessoaComponent]
    });
    fixture = TestBed.createComponent(EnpacotadorPessoaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
