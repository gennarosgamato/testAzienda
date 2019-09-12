import { TestBed } from '@angular/core/testing';

import { ViewAllService } from './view-all.service';

describe('ViewAllService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ViewAllService = TestBed.get(ViewAllService);
    expect(service).toBeTruthy();
  });
});
