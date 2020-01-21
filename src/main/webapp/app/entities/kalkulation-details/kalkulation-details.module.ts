import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { JhipsterSampleApplication55SharedModule } from 'app/shared/shared.module';
import { KalkulationDetailsComponent } from './kalkulation-details.component';
import { KalkulationDetailsDetailComponent } from './kalkulation-details-detail.component';
import { KalkulationDetailsUpdateComponent } from './kalkulation-details-update.component';
import { KalkulationDetailsDeleteDialogComponent } from './kalkulation-details-delete-dialog.component';
import { kalkulationDetailsRoute } from './kalkulation-details.route';

@NgModule({
  imports: [JhipsterSampleApplication55SharedModule, RouterModule.forChild(kalkulationDetailsRoute)],
  declarations: [
    KalkulationDetailsComponent,
    KalkulationDetailsDetailComponent,
    KalkulationDetailsUpdateComponent,
    KalkulationDetailsDeleteDialogComponent
  ],
  entryComponents: [KalkulationDetailsDeleteDialogComponent]
})
export class JhipsterSampleApplication55KalkulationDetailsModule {}
