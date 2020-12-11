import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClimbingAreaComponent } from './climbing-area.component';

describe('ClimbingAreaComponent', () => {
  let component: ClimbingAreaComponent;
  let fixture: ComponentFixture<ClimbingAreaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ClimbingAreaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ClimbingAreaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
