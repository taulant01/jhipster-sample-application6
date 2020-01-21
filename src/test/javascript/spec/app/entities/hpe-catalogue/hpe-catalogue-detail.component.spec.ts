import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { JhipsterSampleApplication55TestModule } from '../../../test.module';
import { HpeCatalogueDetailComponent } from 'app/entities/hpe-catalogue/hpe-catalogue-detail.component';
import { HpeCatalogue } from 'app/shared/model/hpe-catalogue.model';

describe('Component Tests', () => {
  describe('HpeCatalogue Management Detail Component', () => {
    let comp: HpeCatalogueDetailComponent;
    let fixture: ComponentFixture<HpeCatalogueDetailComponent>;
    const route = ({ data: of({ hpeCatalogue: new HpeCatalogue(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [JhipsterSampleApplication55TestModule],
        declarations: [HpeCatalogueDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }]
      })
        .overrideTemplate(HpeCatalogueDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(HpeCatalogueDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should load hpeCatalogue on init', () => {
        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.hpeCatalogue).toEqual(jasmine.objectContaining({ id: 123 }));
      });
    });
  });
});
