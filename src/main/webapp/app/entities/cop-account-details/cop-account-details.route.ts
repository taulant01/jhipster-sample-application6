import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { JhiResolvePagingParams } from 'ng-jhipster';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { ICopAccountDetails, CopAccountDetails } from 'app/shared/model/cop-account-details.model';
import { CopAccountDetailsService } from './cop-account-details.service';
import { CopAccountDetailsComponent } from './cop-account-details.component';
import { CopAccountDetailsDetailComponent } from './cop-account-details-detail.component';
import { CopAccountDetailsUpdateComponent } from './cop-account-details-update.component';

@Injectable({ providedIn: 'root' })
export class CopAccountDetailsResolve implements Resolve<ICopAccountDetails> {
  constructor(private service: CopAccountDetailsService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<ICopAccountDetails> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((copAccountDetails: HttpResponse<CopAccountDetails>) => {
          if (copAccountDetails.body) {
            return of(copAccountDetails.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new CopAccountDetails());
  }
}

export const copAccountDetailsRoute: Routes = [
  {
    path: '',
    component: CopAccountDetailsComponent,
    resolve: {
      pagingParams: JhiResolvePagingParams
    },
    data: {
      authorities: ['ROLE_USER'],
      defaultSort: 'id,asc',
      pageTitle: 'jhipsterSampleApplication55App.copAccountDetails.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/view',
    component: CopAccountDetailsDetailComponent,
    resolve: {
      copAccountDetails: CopAccountDetailsResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'jhipsterSampleApplication55App.copAccountDetails.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'new',
    component: CopAccountDetailsUpdateComponent,
    resolve: {
      copAccountDetails: CopAccountDetailsResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'jhipsterSampleApplication55App.copAccountDetails.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/edit',
    component: CopAccountDetailsUpdateComponent,
    resolve: {
      copAccountDetails: CopAccountDetailsResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'jhipsterSampleApplication55App.copAccountDetails.home.title'
    },
    canActivate: [UserRouteAccessService]
  }
];
