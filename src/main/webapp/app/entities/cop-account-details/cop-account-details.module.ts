import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { JhipsterSampleApplication55SharedModule } from 'app/shared/shared.module';
import { CopAccountDetailsComponent } from './cop-account-details.component';
import { CopAccountDetailsDetailComponent } from './cop-account-details-detail.component';
import { CopAccountDetailsUpdateComponent } from './cop-account-details-update.component';
import { CopAccountDetailsDeleteDialogComponent } from './cop-account-details-delete-dialog.component';
import { copAccountDetailsRoute } from './cop-account-details.route';

@NgModule({
  imports: [JhipsterSampleApplication55SharedModule, RouterModule.forChild(copAccountDetailsRoute)],
  declarations: [
    CopAccountDetailsComponent,
    CopAccountDetailsDetailComponent,
    CopAccountDetailsUpdateComponent,
    CopAccountDetailsDeleteDialogComponent
  ],
  entryComponents: [CopAccountDetailsDeleteDialogComponent]
})
export class JhipsterSampleApplication55CopAccountDetailsModule {}
