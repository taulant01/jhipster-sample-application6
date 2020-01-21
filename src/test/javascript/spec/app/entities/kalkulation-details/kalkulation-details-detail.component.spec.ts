import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { JhipsterSampleApplication55TestModule } from '../../../test.module';
import { KalkulationDetailsDetailComponent } from 'app/entities/kalkulation-details/kalkulation-details-detail.component';
import { KalkulationDetails } from 'app/shared/model/kalkulation-details.model';

describe('Component Tests', () => {
  describe('KalkulationDetails Management Detail Component', () => {
    let comp: KalkulationDetailsDetailComponent;
    let fixture: ComponentFixture<KalkulationDetailsDetailComponent>;
    const route = ({ data: of({ kalkulationDetails: new KalkulationDetails(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [JhipsterSampleApplication55TestModule],
        declarations: [KalkulationDetailsDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }]
      })
        .overrideTemplate(KalkulationDetailsDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(KalkulationDetailsDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should load kalkulationDetails on init', () => {
        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.kalkulationDetails).toEqual(jasmine.objectContaining({ id: 123 }));
      });
    });
  });
});
