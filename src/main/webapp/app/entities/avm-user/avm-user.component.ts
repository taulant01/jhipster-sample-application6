import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { IAvmUser } from 'app/shared/model/avm-user.model';
import { AvmUserService } from './avm-user.service';
import { AvmUserDeleteDialogComponent } from './avm-user-delete-dialog.component';

@Component({
  selector: 'jhi-avm-user',
  templateUrl: './avm-user.component.html'
})
export class AvmUserComponent implements OnInit, OnDestroy {
  avmUsers?: IAvmUser[];
  eventSubscriber?: Subscription;

  constructor(protected avmUserService: AvmUserService, protected eventManager: JhiEventManager, protected modalService: NgbModal) {}

  loadAll(): void {
    this.avmUserService.query().subscribe((res: HttpResponse<IAvmUser[]>) => {
      this.avmUsers = res.body ? res.body : [];
    });
  }

  ngOnInit(): void {
    this.loadAll();
    this.registerChangeInAvmUsers();
  }

  ngOnDestroy(): void {
    if (this.eventSubscriber) {
      this.eventManager.destroy(this.eventSubscriber);
    }
  }

  trackId(index: number, item: IAvmUser): number {
    // eslint-disable-next-line @typescript-eslint/no-unnecessary-type-assertion
    return item.id!;
  }

  registerChangeInAvmUsers(): void {
    this.eventSubscriber = this.eventManager.subscribe('avmUserListModification', () => this.loadAll());
  }

  delete(avmUser: IAvmUser): void {
    const modalRef = this.modalService.open(AvmUserDeleteDialogComponent, { size: 'lg', backdrop: 'static' });
    modalRef.componentInstance.avmUser = avmUser;
  }
}
