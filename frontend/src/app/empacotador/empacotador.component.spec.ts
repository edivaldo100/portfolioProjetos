import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmpacotadorComponent } from './empacotador.component';

describe('EmpacotadorComponent', () => {
  let component: EmpacotadorComponent;
  let fixture: ComponentFixture<EmpacotadorComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [EmpacotadorComponent]
    });
    fixture = TestBed.createComponent(EmpacotadorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
