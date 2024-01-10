import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DisplayPessoaComponent } from './display-pessoa.component';

describe('DisplayPessoaComponent', () => {
  let component: DisplayPessoaComponent;
  let fixture: ComponentFixture<DisplayPessoaComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DisplayPessoaComponent]
    });
    fixture = TestBed.createComponent(DisplayPessoaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
