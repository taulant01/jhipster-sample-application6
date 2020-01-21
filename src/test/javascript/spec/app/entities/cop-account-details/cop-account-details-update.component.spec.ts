import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { of } from 'rxjs';

import { JhipsterSampleApplication55TestModule } from '../../../test.module';
import { CopAccountDetailsUpdateComponent } from 'app/entities/cop-account-details/cop-account-details-update.component';
import { CopAccountDetailsService } from 'app/entities/cop-account-details/cop-account-details.service';
import { CopAccountDetails } from 'app/shared/model/cop-account-details.model';

describe('Component Tests', () => {
  describe('CopAccountDetails Management Update Component', () => {
    let comp: CopAccountDetailsUpdateComponent;
    let fixture: ComponentFixture<CopAccountDetailsUpdateComponent>;
    let service: CopAccountDetailsService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [JhipsterSampleApplication55TestModule],
        declarations: [CopAccountDetailsUpdateComponent],
        providers: [FormBuilder]
      })
        .overrideTemplate(CopAccountDetailsUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(CopAccountDetailsUpdateComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(CopAccountDetailsService);
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', fakeAsync(() => {
        // GIVEN
        const entity = new CopAccountDetails(123);
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
        const entity = new CopAccountDetails();
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
