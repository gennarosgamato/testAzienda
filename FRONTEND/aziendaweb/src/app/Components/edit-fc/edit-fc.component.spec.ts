import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditFCComponent } from './edit-fc.component';

describe('EditFCComponent', () => {
  let component: EditFCComponent;
  let fixture: ComponentFixture<EditFCComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditFCComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditFCComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
