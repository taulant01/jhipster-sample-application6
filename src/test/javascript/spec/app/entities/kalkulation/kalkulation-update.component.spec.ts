import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { of } from 'rxjs';

import { JhipsterSampleApplication55TestModule } from '../../../test.module';
import { KalkulationUpdateComponent } from 'app/entities/kalkulation/kalkulation-update.component';
import { KalkulationService } from 'app/entities/kalkulation/kalkulation.service';
import { Kalkulation } from 'app/shared/model/kalkulation.model';

describe('Component Tests', () => {
  describe('Kalkulation Management Update Component', () => {
    let comp: KalkulationUpdateComponent;
    let fixture: ComponentFixture<KalkulationUpdateComponent>;
    let service: KalkulationService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [JhipsterSampleApplication55TestModule],
        declarations: [KalkulationUpdateComponent],
        providers: [FormBuilder]
      })
        .overrideTemplate(KalkulationUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(KalkulationUpdateComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(KalkulationService);
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', fakeAsync(() => {
        // GIVEN
        const entity = new Kalkulation(123);
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
        const entity = new Kalkulation();
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
