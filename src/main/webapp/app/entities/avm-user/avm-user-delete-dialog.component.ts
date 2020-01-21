import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IAvmUser } from 'app/shared/model/avm-user.model';
import { AvmUserService } from './avm-user.service';

@Component({
  templateUrl: './avm-user-delete-dialog.component.html'
})
export class AvmUserDeleteDialogComponent {
  avmUser?: IAvmUser;

  constructor(protected avmUserService: AvmUserService, public activeModal: NgbActiveModal, protected eventManager: JhiEventManager) {}

  clear(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.avmUserService.delete(id).subscribe(() => {
      this.eventManager.broadcast('avmUserListModification');
      this.activeModal.close();
    });
  }
}
