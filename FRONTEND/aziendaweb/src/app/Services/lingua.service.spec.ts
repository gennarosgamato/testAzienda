import { TestBed } from '@angular/core/testing';

import { LinguaService } from './lingua.service';

describe('LinguaService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: LinguaService = TestBed.get(LinguaService);
    expect(service).toBeTruthy();
  });
});
