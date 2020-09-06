import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TableFieldDetailsComponent } from './table-field-details.component';

describe('TableFieldDetailsComponent', () => {
  let component: TableFieldDetailsComponent;
  let fixture: ComponentFixture<TableFieldDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TableFieldDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TableFieldDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
