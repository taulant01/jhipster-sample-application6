import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { JhipsterSampleApplication55SharedModule } from 'app/shared/shared.module';
import { HpeCatalogueComponent } from './hpe-catalogue.component';
import { HpeCatalogueDetailComponent } from './hpe-catalogue-detail.component';
import { HpeCatalogueUpdateComponent } from './hpe-catalogue-update.component';
import { HpeCatalogueDeleteDialogComponent } from './hpe-catalogue-delete-dialog.component';
import { hpeCatalogueRoute } from './hpe-catalogue.route';

@NgModule({
  imports: [JhipsterSampleApplication55SharedModule, RouterModule.forChild(hpeCatalogueRoute)],
  declarations: [HpeCatalogueComponent, HpeCatalogueDetailComponent, HpeCatalogueUpdateComponent, HpeCatalogueDeleteDialogComponent],
  entryComponents: [HpeCatalogueDeleteDialogComponent]
})
export class JhipsterSampleApplication55HpeCatalogueModule {}
