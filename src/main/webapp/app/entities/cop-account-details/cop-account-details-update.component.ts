import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { ICopAccountDetails, CopAccountDetails } from 'app/shared/model/cop-account-details.model';
import { CopAccountDetailsService } from './cop-account-details.service';

@Component({
  selector: 'jhi-cop-account-details-update',
  templateUrl: './cop-account-details-update.component.html'
})
export class CopAccountDetailsUpdateComponent implements OnInit {
  isSaving = false;

  editForm = this.fb.group({
    id: [],
    copUser: [],
    copPassword: [],
    copName: []
  });

  constructor(
    protected copAccountDetailsService: CopAccountDetailsService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ copAccountDetails }) => {
      this.updateForm(copAccountDetails);
    });
  }

  updateForm(copAccountDetails: ICopAccountDetails): void {
    this.editForm.patchValue({
      id: copAccountDetails.id,
      copUser: copAccountDetails.copUser,
      copPassword: copAccountDetails.copPassword,
      copName: copAccountDetails.copName
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const copAccountDetails = this.createFromForm();
    if (copAccountDetails.id !== undefined) {
      this.subscribeToSaveResponse(this.copAccountDetailsService.update(copAccountDetails));
    } else {
      this.subscribeToSaveResponse(this.copAccountDetailsService.create(copAccountDetails));
    }
  }

  private createFromForm(): ICopAccountDetails {
    return {
      ...new CopAccountDetails(),
      id: this.editForm.get(['id'])!.value,
      copUser: this.editForm.get(['copUser'])!.value,
      copPassword: this.editForm.get(['copPassword'])!.value,
      copName: this.editForm.get(['copName'])!.value
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<ICopAccountDetails>>): void {
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
}
