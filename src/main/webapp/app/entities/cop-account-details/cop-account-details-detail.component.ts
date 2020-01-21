import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { ICopAccountDetails } from 'app/shared/model/cop-account-details.model';

@Component({
  selector: 'jhi-cop-account-details-detail',
  templateUrl: './cop-account-details-detail.component.html'
})
export class CopAccountDetailsDetailComponent implements OnInit {
  copAccountDetails: ICopAccountDetails | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ copAccountDetails }) => {
      this.copAccountDetails = copAccountDetails;
    });
  }

  previousState(): void {
    window.history.back();
  }
}
