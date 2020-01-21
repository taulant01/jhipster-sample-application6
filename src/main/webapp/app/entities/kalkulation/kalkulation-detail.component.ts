import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IKalkulation } from 'app/shared/model/kalkulation.model';

@Component({
  selector: 'jhi-kalkulation-detail',
  templateUrl: './kalkulation-detail.component.html'
})
export class KalkulationDetailComponent implements OnInit {
  kalkulation: IKalkulation | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ kalkulation }) => {
      this.kalkulation = kalkulation;
    });
  }

  previousState(): void {
    window.history.back();
  }
}
