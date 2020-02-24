import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ErsRequestsComponent } from './ers-requests.component';

describe('ErsRequestsComponent', () => {
  let component: ErsRequestsComponent;
  let fixture: ComponentFixture<ErsRequestsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ErsRequestsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ErsRequestsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
