import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteFCComponent } from './delete-fc.component';

describe('DeleteFCComponent', () => {
  let component: DeleteFCComponent;
  let fixture: ComponentFixture<DeleteFCComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DeleteFCComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DeleteFCComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
