import { TestBed } from '@angular/core/testing';

import { ViewAllEmployeeService } from './view-all-employee.service';

describe('ViewAllEmployeeService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ViewAllEmployeeService = TestBed.get(ViewAllEmployeeService);
    expect(service).toBeTruthy();
  });
});
