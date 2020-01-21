import { ComponentFixture, TestBed } from '@angular/core/testing';
import { of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';
import { ActivatedRoute, Data } from '@angular/router';

import { JhipsterSampleApplication55TestModule } from '../../../test.module';
import { HpeCatalogueComponent } from 'app/entities/hpe-catalogue/hpe-catalogue.component';
import { HpeCatalogueService } from 'app/entities/hpe-catalogue/hpe-catalogue.service';
import { HpeCatalogue } from 'app/shared/model/hpe-catalogue.model';

describe('Component Tests', () => {
  describe('HpeCatalogue Management Component', () => {
    let comp: HpeCatalogueComponent;
    let fixture: ComponentFixture<HpeCatalogueComponent>;
    let service: HpeCatalogueService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [JhipsterSampleApplication55TestModule],
        declarations: [HpeCatalogueComponent],
        providers: [
          {
            provide: ActivatedRoute,
            useValue: {
              data: {
                subscribe: (fn: (value: Data) => void) =>
                  fn({
                    pagingParams: {
                      predicate: 'id',
                      reverse: false,
                      page: 0
                    }
                  })
              }
            }
          }
        ]
      })
        .overrideTemplate(HpeCatalogueComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(HpeCatalogueComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(HpeCatalogueService);
    });

    it('Should call load all on init', () => {
      // GIVEN
      const headers = new HttpHeaders().append('link', 'link;link');
      spyOn(service, 'query').and.returnValue(
        of(
          new HttpResponse({
            body: [new HpeCatalogue(123)],
            headers
          })
        )
      );

      // WHEN
      comp.ngOnInit();

      // THEN
      expect(service.query).toHaveBeenCalled();
      expect(comp.hpeCatalogues && comp.hpeCatalogues[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });

    it('should load a page', () => {
      // GIVEN
      const headers = new HttpHeaders().append('link', 'link;link');
      spyOn(service, 'query').and.returnValue(
        of(
          new HttpResponse({
            body: [new HpeCatalogue(123)],
            headers
          })
        )
      );

      // WHEN
      comp.loadPage(1);

      // THEN
      expect(service.query).toHaveBeenCalled();
      expect(comp.hpeCatalogues && comp.hpeCatalogues[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });

    it('should calculate the sort attribute for an id', () => {
      // WHEN
      comp.ngOnInit();
      const result = comp.sort();

      // THEN
      expect(result).toEqual(['id,desc']);
    });

    it('should calculate the sort attribute for a non-id attribute', () => {
      // INIT
      comp.ngOnInit();

      // GIVEN
      comp.predicate = 'name';

      // WHEN
      const result = comp.sort();

      // THEN
      expect(result).toEqual(['name,desc', 'id']);
    });
  });
});
