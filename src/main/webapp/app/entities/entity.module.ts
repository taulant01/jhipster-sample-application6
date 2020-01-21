import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: 'kalkulation',
        loadChildren: () => import('./kalkulation/kalkulation.module').then(m => m.JhipsterSampleApplication55KalkulationModule)
      },
      {
        path: 'kalkulation-details',
        loadChildren: () =>
          import('./kalkulation-details/kalkulation-details.module').then(m => m.JhipsterSampleApplication55KalkulationDetailsModule)
      },
      {
        path: 'hpe-catalogue',
        loadChildren: () => import('./hpe-catalogue/hpe-catalogue.module').then(m => m.JhipsterSampleApplication55HpeCatalogueModule)
      },
      {
        path: 'cop-account-details',
        loadChildren: () =>
          import('./cop-account-details/cop-account-details.module').then(m => m.JhipsterSampleApplication55CopAccountDetailsModule)
      },
      {
        path: 'avm-user',
        loadChildren: () => import('./avm-user/avm-user.module').then(m => m.JhipsterSampleApplication55AvmUserModule)
      }
      /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
    ])
  ]
})
export class JhipsterSampleApplication55EntityModule {}
