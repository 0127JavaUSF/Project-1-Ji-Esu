import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MgrHeaderComponent } from './mgr-header.component';

describe('MgrHeaderComponent', () => {
  let component: MgrHeaderComponent;
  let fixture: ComponentFixture<MgrHeaderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MgrHeaderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MgrHeaderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
