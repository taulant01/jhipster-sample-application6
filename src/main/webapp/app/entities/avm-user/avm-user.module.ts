import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { JhipsterSampleApplication55SharedModule } from 'app/shared/shared.module';
import { AvmUserComponent } from './avm-user.component';
import { AvmUserDetailComponent } from './avm-user-detail.component';
import { AvmUserUpdateComponent } from './avm-user-update.component';
import { AvmUserDeleteDialogComponent } from './avm-user-delete-dialog.component';
import { avmUserRoute } from './avm-user.route';

@NgModule({
  imports: [JhipsterSampleApplication55SharedModule, RouterModule.forChild(avmUserRoute)],
  declarations: [AvmUserComponent, AvmUserDetailComponent, AvmUserUpdateComponent, AvmUserDeleteDialogComponent],
  entryComponents: [AvmUserDeleteDialogComponent]
})
export class JhipsterSampleApplication55AvmUserModule {}
