import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { IKalkulationDetails, KalkulationDetails } from 'app/shared/model/kalkulation-details.model';
import { KalkulationDetailsService } from './kalkulation-details.service';
import { IKalkulation } from 'app/shared/model/kalkulation.model';
import { KalkulationService } from 'app/entities/kalkulation/kalkulation.service';

@Component({
  selector: 'jhi-kalkulation-details-update',
  templateUrl: './kalkulation-details-update.component.html'
})
export class KalkulationDetailsUpdateComponent implements OnInit {
  isSaving = false;

  kalkulations: IKalkulation[] = [];

  editForm = this.fb.group({
    id: [],
    a: [],
    b: [],
    c: [],
    d: [],
    e: [],
    f: [],
    g: [],
    h: [],
    i: [],
    j: [],
    k: [],
    l: [],
    m: [],
    n: [],
    o: [],
    p: [],
    q: [],
    r: [],
    s: [],
    t: [],
    u: [],
    v: [],
    w: [],
    x: [],
    y: [],
    z: [],
    aa: [],
    ab: [],
    ac: [],
    ad: [],
    ae: [],
    af: [],
    ag: [],
    kalkulation: []
  });

  constructor(
    protected kalkulationDetailsService: KalkulationDetailsService,
    protected kalkulationService: KalkulationService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ kalkulationDetails }) => {
      this.updateForm(kalkulationDetails);

      this.kalkulationService
        .query()
        .pipe(
          map((res: HttpResponse<IKalkulation[]>) => {
            return res.body ? res.body : [];
          })
        )
        .subscribe((resBody: IKalkulation[]) => (this.kalkulations = resBody));
    });
  }

  updateForm(kalkulationDetails: IKalkulationDetails): void {
    this.editForm.patchValue({
      id: kalkulationDetails.id,
      a: kalkulationDetails.a,
      b: kalkulationDetails.b,
      c: kalkulationDetails.c,
      d: kalkulationDetails.d,
      e: kalkulationDetails.e,
      f: kalkulationDetails.f,
      g: kalkulationDetails.g,
      h: kalkulationDetails.h,
      i: kalkulationDetails.i,
      j: kalkulationDetails.j,
      k: kalkulationDetails.k,
      l: kalkulationDetails.l,
      m: kalkulationDetails.m,
      n: kalkulationDetails.n,
      o: kalkulationDetails.o,
      p: kalkulationDetails.p,
      q: kalkulationDetails.q,
      r: kalkulationDetails.r,
      s: kalkulationDetails.s,
      t: kalkulationDetails.t,
      u: kalkulationDetails.u,
      v: kalkulationDetails.v,
      w: kalkulationDetails.w,
      x: kalkulationDetails.x,
      y: kalkulationDetails.y,
      z: kalkulationDetails.z,
      aa: kalkulationDetails.aa,
      ab: kalkulationDetails.ab,
      ac: kalkulationDetails.ac,
      ad: kalkulationDetails.ad,
      ae: kalkulationDetails.ae,
      af: kalkulationDetails.af,
      ag: kalkulationDetails.ag,
      kalkulation: kalkulationDetails.kalkulation
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const kalkulationDetails = this.createFromForm();
    if (kalkulationDetails.id !== undefined) {
      this.subscribeToSaveResponse(this.kalkulationDetailsService.update(kalkulationDetails));
    } else {
      this.subscribeToSaveResponse(this.kalkulationDetailsService.create(kalkulationDetails));
    }
  }

  private createFromForm(): IKalkulationDetails {
    return {
      ...new KalkulationDetails(),
      id: this.editForm.get(['id'])!.value,
      a: this.editForm.get(['a'])!.value,
      b: this.editForm.get(['b'])!.value,
      c: this.editForm.get(['c'])!.value,
      d: this.editForm.get(['d'])!.value,
      e: this.editForm.get(['e'])!.value,
      f: this.editForm.get(['f'])!.value,
      g: this.editForm.get(['g'])!.value,
      h: this.editForm.get(['h'])!.value,
      i: this.editForm.get(['i'])!.value,
      j: this.editForm.get(['j'])!.value,
      k: this.editForm.get(['k'])!.value,
      l: this.editForm.get(['l'])!.value,
      m: this.editForm.get(['m'])!.value,
      n: this.editForm.get(['n'])!.value,
      o: this.editForm.get(['o'])!.value,
      p: this.editForm.get(['p'])!.value,
      q: this.editForm.get(['q'])!.value,
      r: this.editForm.get(['r'])!.value,
      s: this.editForm.get(['s'])!.value,
      t: this.editForm.get(['t'])!.value,
      u: this.editForm.get(['u'])!.value,
      v: this.editForm.get(['v'])!.value,
      w: this.editForm.get(['w'])!.value,
      x: this.editForm.get(['x'])!.value,
      y: this.editForm.get(['y'])!.value,
      z: this.editForm.get(['z'])!.value,
      aa: this.editForm.get(['aa'])!.value,
      ab: this.editForm.get(['ab'])!.value,
      ac: this.editForm.get(['ac'])!.value,
      ad: this.editForm.get(['ad'])!.value,
      ae: this.editForm.get(['ae'])!.value,
      af: this.editForm.get(['af'])!.value,
      ag: this.editForm.get(['ag'])!.value,
      kalkulation: this.editForm.get(['kalkulation'])!.value
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IKalkulationDetails>>): void {
    result.subscribe(
      () => this.onSaveSuccess(),
      () => this.onSaveError()
    );
  }

  protected onSaveSuccess(): void {
    this.isSaving = false;
    this.previousState();
  }

  protected onSaveError(): void {
    this.isSaving = false;
  }

  trackById(index: number, item: IKalkulation): any {
    return item.id;
  }
}
