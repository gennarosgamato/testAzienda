import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewAllFCComponent } from './view-all-fc.component';

describe('ViewAllFCComponent', () => {
  let component: ViewAllFCComponent;
  let fixture: ComponentFixture<ViewAllFCComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewAllFCComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewAllFCComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
