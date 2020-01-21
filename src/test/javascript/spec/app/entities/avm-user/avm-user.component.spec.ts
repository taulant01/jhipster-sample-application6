import { ComponentFixture, TestBed } from '@angular/core/testing';
import { of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { JhipsterSampleApplication55TestModule } from '../../../test.module';
import { AvmUserComponent } from 'app/entities/avm-user/avm-user.component';
import { AvmUserService } from 'app/entities/avm-user/avm-user.service';
import { AvmUser } from 'app/shared/model/avm-user.model';

describe('Component Tests', () => {
  describe('AvmUser Management Component', () => {
    let comp: AvmUserComponent;
    let fixture: ComponentFixture<AvmUserComponent>;
    let service: AvmUserService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [JhipsterSampleApplication55TestModule],
        declarations: [AvmUserComponent],
        providers: []
      })
        .overrideTemplate(AvmUserComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(AvmUserComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(AvmUserService);
    });

    it('Should call load all on init', () => {
      // GIVEN
      const headers = new HttpHeaders().append('link', 'link;link');
      spyOn(service, 'query').and.returnValue(
        of(
          new HttpResponse({
            body: [new AvmUser(123)],
            headers
          })
        )
      );

      // WHEN
      comp.ngOnInit();

      // THEN
      expect(service.query).toHaveBeenCalled();
      expect(comp.avmUsers && comp.avmUsers[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });
  });
});
