import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IKalkulationDetails } from 'app/shared/model/kalkulation-details.model';
import { KalkulationDetailsService } from './kalkulation-details.service';

@Component({
  templateUrl: './kalkulation-details-delete-dialog.component.html'
})
export class KalkulationDetailsDeleteDialogComponent {
  kalkulationDetails?: IKalkulationDetails;

  constructor(
    protected kalkulationDetailsService: KalkulationDetailsService,
    public activeModal: NgbActiveModal,
    protected eventManager: JhiEventManager
  ) {}

  clear(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.kalkulationDetailsService.delete(id).subscribe(() => {
      this.eventManager.broadcast('kalkulationDetailsListModification');
      this.activeModal.close();
    });
  }
}
