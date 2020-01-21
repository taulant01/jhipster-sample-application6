import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { JhipsterSampleApplication55TestModule } from '../../../test.module';
import { CopAccountDetailsDetailComponent } from 'app/entities/cop-account-details/cop-account-details-detail.component';
import { CopAccountDetails } from 'app/shared/model/cop-account-details.model';

describe('Component Tests', () => {
  describe('CopAccountDetails Management Detail Component', () => {
    let comp: CopAccountDetailsDetailComponent;
    let fixture: ComponentFixture<CopAccountDetailsDetailComponent>;
    const route = ({ data: of({ copAccountDetails: new CopAccountDetails(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [JhipsterSampleApplication55TestModule],
        declarations: [CopAccountDetailsDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }]
      })
        .overrideTemplate(CopAccountDetailsDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(CopAccountDetailsDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should load copAccountDetails on init', () => {
        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.copAccountDetails).toEqual(jasmine.objectContaining({ id: 123 }));
      });
    });
  });
});
