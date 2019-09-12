import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GenerateFCComponent } from './generate-fc.component';

describe('GenerateFCComponent', () => {
  let component: GenerateFCComponent;
  let fixture: ComponentFixture<GenerateFCComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GenerateFCComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GenerateFCComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
