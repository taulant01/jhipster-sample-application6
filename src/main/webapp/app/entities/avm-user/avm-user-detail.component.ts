import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IAvmUser } from 'app/shared/model/avm-user.model';

@Component({
  selector: 'jhi-avm-user-detail',
  templateUrl: './avm-user-detail.component.html'
})
export class AvmUserDetailComponent implements OnInit {
  avmUser: IAvmUser | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ avmUser }) => {
      this.avmUser = avmUser;
    });
  }

  previousState(): void {
    window.history.back();
  }
}
