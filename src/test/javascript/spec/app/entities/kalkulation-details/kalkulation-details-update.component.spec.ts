import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { of } from 'rxjs';

import { JhipsterSampleApplication55TestModule } from '../../../test.module';
import { KalkulationDetailsUpdateComponent } from 'app/entities/kalkulation-details/kalkulation-details-update.component';
import { KalkulationDetailsService } from 'app/entities/kalkulation-details/kalkulation-details.service';
import { KalkulationDetails } from 'app/shared/model/kalkulation-details.model';

describe('Component Tests', () => {
  describe('KalkulationDetails Management Update Component', () => {
    let comp: KalkulationDetailsUpdateComponent;
    let fixture: ComponentFixture<KalkulationDetailsUpdateComponent>;
    let service: KalkulationDetailsService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [JhipsterSampleApplication55TestModule],
        declarations: [KalkulationDetailsUpdateComponent],
        providers: [FormBuilder]
      })
        .overrideTemplate(KalkulationDetailsUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(KalkulationDetailsUpdateComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(KalkulationDetailsService);
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', fakeAsync(() => {
        // GIVEN
        const entity = new KalkulationDetails(123);
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
        const entity = new KalkulationDetails();
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
