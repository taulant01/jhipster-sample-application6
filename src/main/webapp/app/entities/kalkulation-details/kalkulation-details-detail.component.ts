import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IKalkulationDetails } from 'app/shared/model/kalkulation-details.model';

@Component({
  selector: 'jhi-kalkulation-details-detail',
  templateUrl: './kalkulation-details-detail.component.html'
})
export class KalkulationDetailsDetailComponent implements OnInit {
  kalkulationDetails: IKalkulationDetails | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ kalkulationDetails }) => {
      this.kalkulationDetails = kalkulationDetails;
    });
  }

  previousState(): void {
    window.history.back();
  }
}
