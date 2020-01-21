import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { JhiResolvePagingParams } from 'ng-jhipster';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { IKalkulation, Kalkulation } from 'app/shared/model/kalkulation.model';
import { KalkulationService } from './kalkulation.service';
import { KalkulationComponent } from './kalkulation.component';
import { KalkulationDetailComponent } from './kalkulation-detail.component';
import { KalkulationUpdateComponent } from './kalkulation-update.component';

@Injectable({ providedIn: 'root' })
export class KalkulationResolve implements Resolve<IKalkulation> {
  constructor(private service: KalkulationService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IKalkulation> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((kalkulation: HttpResponse<Kalkulation>) => {
          if (kalkulation.body) {
            return of(kalkulation.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new Kalkulation());
  }
}

export const kalkulationRoute: Routes = [
  {
    path: '',
    component: KalkulationComponent,
    resolve: {
      pagingParams: JhiResolvePagingParams
    },
    data: {
      authorities: ['ROLE_USER'],
      defaultSort: 'id,asc',
      pageTitle: 'jhipsterSampleApplication55App.kalkulation.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/view',
    component: KalkulationDetailComponent,
    resolve: {
      kalkulation: KalkulationResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'jhipsterSampleApplication55App.kalkulation.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'new',
    component: KalkulationUpdateComponent,
    resolve: {
      kalkulation: KalkulationResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'jhipsterSampleApplication55App.kalkulation.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/edit',
    component: KalkulationUpdateComponent,
    resolve: {
      kalkulation: KalkulationResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'jhipsterSampleApplication55App.kalkulation.home.title'
    },
    canActivate: [UserRouteAccessService]
  }
];
