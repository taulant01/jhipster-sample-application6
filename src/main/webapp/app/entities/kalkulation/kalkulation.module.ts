import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { JhipsterSampleApplication55SharedModule } from 'app/shared/shared.module';
import { KalkulationComponent } from './kalkulation.component';
import { KalkulationDetailComponent } from './kalkulation-detail.component';
import { KalkulationUpdateComponent } from './kalkulation-update.component';
import { KalkulationDeleteDialogComponent } from './kalkulation-delete-dialog.component';
import { kalkulationRoute } from './kalkulation.route';

@NgModule({
  imports: [JhipsterSampleApplication55SharedModule, RouterModule.forChild(kalkulationRoute)],
  declarations: [KalkulationComponent, KalkulationDetailComponent, KalkulationUpdateComponent, KalkulationDeleteDialogComponent],
  entryComponents: [KalkulationDeleteDialogComponent]
})
export class JhipsterSampleApplication55KalkulationModule {}
