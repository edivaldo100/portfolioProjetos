import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProjetoInputComponent } from './projeto-input.component';

describe('ProjetoInputComponent', () => {
  let component: ProjetoInputComponent;
  let fixture: ComponentFixture<ProjetoInputComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ProjetoInputComponent]
    });
    fixture = TestBed.createComponent(ProjetoInputComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
