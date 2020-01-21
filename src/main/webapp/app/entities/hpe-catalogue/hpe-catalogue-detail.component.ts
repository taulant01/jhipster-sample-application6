import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IHpeCatalogue } from 'app/shared/model/hpe-catalogue.model';

@Component({
  selector: 'jhi-hpe-catalogue-detail',
  templateUrl: './hpe-catalogue-detail.component.html'
})
export class HpeCatalogueDetailComponent implements OnInit {
  hpeCatalogue: IHpeCatalogue | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ hpeCatalogue }) => {
      this.hpeCatalogue = hpeCatalogue;
    });
  }

  previousState(): void {
    window.history.back();
  }
}
