import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { of } from 'rxjs';

import { JhipsterSampleApplication55TestModule } from '../../../test.module';
import { HpeCatalogueUpdateComponent } from 'app/entities/hpe-catalogue/hpe-catalogue-update.component';
import { HpeCatalogueService } from 'app/entities/hpe-catalogue/hpe-catalogue.service';
import { HpeCatalogue } from 'app/shared/model/hpe-catalogue.model';

describe('Component Tests', () => {
  describe('HpeCatalogue Management Update Component', () => {
    let comp: HpeCatalogueUpdateComponent;
    let fixture: ComponentFixture<HpeCatalogueUpdateComponent>;
    let service: HpeCatalogueService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [JhipsterSampleApplication55TestModule],
        declarations: [HpeCatalogueUpdateComponent],
        providers: [FormBuilder]
      })
        .overrideTemplate(HpeCatalogueUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(HpeCatalogueUpdateComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(HpeCatalogueService);
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', fakeAsync(() => {
        // GIVEN
        const entity = new HpeCatalogue(123);
        spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
        comp.updateForm(entity);
        // WHEN
        comp.save();
        tick(); // simulate async

        // THEN
        expect(service.update).toHaveBeenCalledWith(entity);
        expect(comp.isSaving).toEqual(false);
      }));

      it('Should call create service on save for new entity', fakeAsync(() => {
        // GIVEN
        const entity = new HpeCatalogue();
        spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
        comp.updateForm(entity);
        // WHEN
        comp.save();
        tick(); // simulate async

        // THEN
        expect(service.create).toHaveBeenCalledWith(entity);
        expect(comp.isSaving).toEqual(false);
      }));
    });
  });
});
