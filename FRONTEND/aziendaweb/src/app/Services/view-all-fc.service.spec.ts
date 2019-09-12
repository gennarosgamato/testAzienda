import { TestBed } from '@angular/core/testing';

import { ViewAllFCService } from './view-all-fc.service';

describe('ViewAllFCService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ViewAllFCService = TestBed.get(ViewAllFCService);
    expect(service).toBeTruthy();
  });
});
