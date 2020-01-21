import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { ICopAccountDetails } from 'app/shared/model/cop-account-details.model';
import { CopAccountDetailsService } from './cop-account-details.service';

@Component({
  templateUrl: './cop-account-details-delete-dialog.component.html'
})
export class CopAccountDetailsDeleteDialogComponent {
  copAccountDetails?: ICopAccountDetails;

  constructor(
    protected copAccountDetailsService: CopAccountDetailsService,
    public activeModal: NgbActiveModal,
    protected eventManager: JhiEventManager
  ) {}

  clear(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.copAccountDetailsService.delete(id).subscribe(() => {
      this.eventManager.broadcast('copAccountDetailsListModification');
      this.activeModal.close();
    });
  }
}
