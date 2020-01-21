import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { JhiResolvePagingParams } from 'ng-jhipster';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { IHpeCatalogue, HpeCatalogue } from 'app/shared/model/hpe-catalogue.model';
import { HpeCatalogueService } from './hpe-catalogue.service';
import { HpeCatalogueComponent } from './hpe-catalogue.component';
import { HpeCatalogueDetailComponent } from './hpe-catalogue-detail.component';
import { HpeCatalogueUpdateComponent } from './hpe-catalogue-update.component';

@Injectable({ providedIn: 'root' })
export class HpeCatalogueResolve implements Resolve<IHpeCatalogue> {
  constructor(private service: HpeCatalogueService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IHpeCatalogue> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((hpeCatalogue: HttpResponse<HpeCatalogue>) => {
          if (hpeCatalogue.body) {
            return of(hpeCatalogue.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new HpeCatalogue());
  }
}

export const hpeCatalogueRoute: Routes = [
  {
    path: '',
    component: HpeCatalogueComponent,
    resolve: {
      pagingParams: JhiResolvePagingParams
    },
    data: {
      authorities: ['ROLE_USER'],
      defaultSort: 'id,asc',
      pageTitle: 'jhipsterSampleApplication55App.hpeCatalogue.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/view',
    component: HpeCatalogueDetailComponent,
    resolve: {
      hpeCatalogue: HpeCatalogueResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'jhipsterSampleApplication55App.hpeCatalogue.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'new',
    component: HpeCatalogueUpdateComponent,
    resolve: {
      hpeCatalogue: HpeCatalogueResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'jhipsterSampleApplication55App.hpeCatalogue.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/edit',
    component: HpeCatalogueUpdateComponent,
    resolve: {
      hpeCatalogue: HpeCatalogueResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'jhipsterSampleApplication55App.hpeCatalogue.home.title'
    },
    canActivate: [UserRouteAccessService]
  }
];
