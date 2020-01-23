/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { TramsService } from './trams.service';

describe('Service: Trams', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [TramsService]
    });
  });

  it('should ...', inject([TramsService], (service: TramsService) => {
    expect(service).toBeTruthy();
  }));
});
