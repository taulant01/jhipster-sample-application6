import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { of } from 'rxjs';

import { JhipsterSampleApplication55TestModule } from '../../../test.module';
import { AvmUserUpdateComponent } from 'app/entities/avm-user/avm-user-update.component';
import { AvmUserService } from 'app/entities/avm-user/avm-user.service';
import { AvmUser } from 'app/shared/model/avm-user.model';

describe('Component Tests', () => {
  describe('AvmUser Management Update Component', () => {
    let comp: AvmUserUpdateComponent;
    let fixture: ComponentFixture<AvmUserUpdateComponent>;
    let service: AvmUserService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [JhipsterSampleApplication55TestModule],
        declarations: [AvmUserUpdateComponent],
        providers: [FormBuilder]
      })
        .overrideTemplate(AvmUserUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(AvmUserUpdateComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(AvmUserService);
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', fakeAsync(() => {
        // GIVEN
        const entity = new AvmUser(123);
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
        const entity = new AvmUser();
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
