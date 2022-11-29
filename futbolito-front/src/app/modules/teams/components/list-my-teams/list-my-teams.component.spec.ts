import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListMyTeamsComponent } from './list-my-teams.component';

describe('ListMyTeamsComponent', () => {
  let component: ListMyTeamsComponent;
  let fixture: ComponentFixture<ListMyTeamsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListMyTeamsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListMyTeamsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
