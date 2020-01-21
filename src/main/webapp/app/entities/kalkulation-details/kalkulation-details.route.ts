import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { JhiResolvePagingParams } from 'ng-jhipster';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { IKalkulationDetails, KalkulationDetails } from 'app/shared/model/kalkulation-details.model';
import { KalkulationDetailsService } from './kalkulation-details.service';
import { KalkulationDetailsComponent } from './kalkulation-details.component';
import { KalkulationDetailsDetailComponent } from './kalkulation-details-detail.component';
import { KalkulationDetailsUpdateComponent } from './kalkulation-details-update.component';

@Injectable({ providedIn: 'root' })
export class KalkulationDetailsResolve implements Resolve<IKalkulationDetails> {
  constructor(private service: KalkulationDetailsService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IKalkulationDetails> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((kalkulationDetails: HttpResponse<KalkulationDetails>) => {
          if (kalkulationDetails.body) {
            return of(kalkulationDetails.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new KalkulationDetails());
  }
}

export const kalkulationDetailsRoute: Routes = [
  {
    path: '',
    component: KalkulationDetailsComponent,
    resolve: {
      pagingParams: JhiResolvePagingParams
    },
    data: {
      authorities: ['ROLE_USER'],
      defaultSort: 'id,asc',
      pageTitle: 'jhipsterSampleApplication55App.kalkulationDetails.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/view',
    component: KalkulationDetailsDetailComponent,
    resolve: {
      kalkulationDetails: KalkulationDetailsResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'jhipsterSampleApplication55App.kalkulationDetails.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'new',
    component: KalkulationDetailsUpdateComponent,
    resolve: {
      kalkulationDetails: KalkulationDetailsResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'jhipsterSampleApplication55App.kalkulationDetails.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/edit',
    component: KalkulationDetailsUpdateComponent,
    resolve: {
      kalkulationDetails: KalkulationDetailsResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'jhipsterSampleApplication55App.kalkulationDetails.home.title'
    },
    canActivate: [UserRouteAccessService]
  }
];
