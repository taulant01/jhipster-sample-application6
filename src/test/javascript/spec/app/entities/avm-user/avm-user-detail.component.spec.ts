import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { JhipsterSampleApplication55TestModule } from '../../../test.module';
import { AvmUserDetailComponent } from 'app/entities/avm-user/avm-user-detail.component';
import { AvmUser } from 'app/shared/model/avm-user.model';

describe('Component Tests', () => {
  describe('AvmUser Management Detail Component', () => {
    let comp: AvmUserDetailComponent;
    let fixture: ComponentFixture<AvmUserDetailComponent>;
    const route = ({ data: of({ avmUser: new AvmUser(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [JhipsterSampleApplication55TestModule],
        declarations: [AvmUserDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }]
      })
        .overrideTemplate(AvmUserDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(AvmUserDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should load avmUser on init', () => {
        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.avmUser).toEqual(jasmine.objectContaining({ id: 123 }));
      });
    });
  });
});
