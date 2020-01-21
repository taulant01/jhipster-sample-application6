import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { IAvmUser, AvmUser } from 'app/shared/model/avm-user.model';
import { AvmUserService } from './avm-user.service';
import { AvmUserComponent } from './avm-user.component';
import { AvmUserDetailComponent } from './avm-user-detail.component';
import { AvmUserUpdateComponent } from './avm-user-update.component';

@Injectable({ providedIn: 'root' })
export class AvmUserResolve implements Resolve<IAvmUser> {
  constructor(private service: AvmUserService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IAvmUser> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((avmUser: HttpResponse<AvmUser>) => {
          if (avmUser.body) {
            return of(avmUser.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new AvmUser());
  }
}

export const avmUserRoute: Routes = [
  {
    path: '',
    component: AvmUserComponent,
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'jhipsterSampleApplication55App.avmUser.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/view',
    component: AvmUserDetailComponent,
    resolve: {
      avmUser: AvmUserResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'jhipsterSampleApplication55App.avmUser.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'new',
    component: AvmUserUpdateComponent,
    resolve: {
      avmUser: AvmUserResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'jhipsterSampleApplication55App.avmUser.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/edit',
    component: AvmUserUpdateComponent,
    resolve: {
      avmUser: AvmUserResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'jhipsterSampleApplication55App.avmUser.home.title'
    },
    canActivate: [UserRouteAccessService]
  }
];
