import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddFCComponent } from './add-fc.component';

describe('AddFCComponent', () => {
  let component: AddFCComponent;
  let fixture: ComponentFixture<AddFCComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddFCComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddFCComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
