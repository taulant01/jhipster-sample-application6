import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IHpeCatalogue } from 'app/shared/model/hpe-catalogue.model';
import { HpeCatalogueService } from './hpe-catalogue.service';

@Component({
  templateUrl: './hpe-catalogue-delete-dialog.component.html'
})
export class HpeCatalogueDeleteDialogComponent {
  hpeCatalogue?: IHpeCatalogue;

  constructor(
    protected hpeCatalogueService: HpeCatalogueService,
    public activeModal: NgbActiveModal,
    protected eventManager: JhiEventManager
  ) {}

  clear(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.hpeCatalogueService.delete(id).subscribe(() => {
      this.eventManager.broadcast('hpeCatalogueListModification');
      this.activeModal.close();
    });
  }
}
