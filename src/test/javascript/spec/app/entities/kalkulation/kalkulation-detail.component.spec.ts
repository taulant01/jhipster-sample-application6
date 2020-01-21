import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { JhipsterSampleApplication55TestModule } from '../../../test.module';
import { KalkulationDetailComponent } from 'app/entities/kalkulation/kalkulation-detail.component';
import { Kalkulation } from 'app/shared/model/kalkulation.model';

describe('Component Tests', () => {
  describe('Kalkulation Management Detail Component', () => {
    let comp: KalkulationDetailComponent;
    let fixture: ComponentFixture<KalkulationDetailComponent>;
    const route = ({ data: of({ kalkulation: new Kalkulation(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [JhipsterSampleApplication55TestModule],
        declarations: [KalkulationDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }]
      })
        .overrideTemplate(KalkulationDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(KalkulationDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should load kalkulation on init', () => {
        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.kalkulation).toEqual(jasmine.objectContaining({ id: 123 }));
      });
    });
  });
});
