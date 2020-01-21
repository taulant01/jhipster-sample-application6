import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IKalkulation } from 'app/shared/model/kalkulation.model';
import { KalkulationService } from './kalkulation.service';

@Component({
  templateUrl: './kalkulation-delete-dialog.component.html'
})
export class KalkulationDeleteDialogComponent {
  kalkulation?: IKalkulation;

  constructor(
    protected kalkulationService: KalkulationService,
    public activeModal: NgbActiveModal,
    protected eventManager: JhiEventManager
  ) {}

  clear(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.kalkulationService.delete(id).subscribe(() => {
      this.eventManager.broadcast('kalkulationListModification');
      this.activeModal.close();
    });
  }
}
