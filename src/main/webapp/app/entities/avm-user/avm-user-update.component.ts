import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { IAvmUser, AvmUser } from 'app/shared/model/avm-user.model';
import { AvmUserService } from './avm-user.service';
import { ICopAccountDetails } from 'app/shared/model/cop-account-details.model';
import { CopAccountDetailsService } from 'app/entities/cop-account-details/cop-account-details.service';

@Component({
  selector: 'jhi-avm-user-update',
  templateUrl: './avm-user-update.component.html'
})
export class AvmUserUpdateComponent implements OnInit {
  isSaving = false;

  copaccountdetails: ICopAccountDetails[] = [];

  editForm = this.fb.group({
    id: [],
    copAccountDetails: []
  });

  constructor(
    protected avmUserService: AvmUserService,
    protected copAccountDetailsService: CopAccountDetailsService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ avmUser }) => {
      this.updateForm(avmUser);

      this.copAccountDetailsService
        .query({ filter: 'avmuser-is-null' })
        .pipe(
          map((res: HttpResponse<ICopAccountDetails[]>) => {
            return res.body ? res.body : [];
          })
        )
        .subscribe((resBody: ICopAccountDetails[]) => {
          if (!avmUser.copAccountDetails || !avmUser.copAccountDetails.id) {
            this.copaccountdetails = resBody;
          } else {
            this.copAccountDetailsService
              .find(avmUser.copAccountDetails.id)
              .pipe(
                map((subRes: HttpResponse<ICopAccountDetails>) => {
                  return subRes.body ? [subRes.body].concat(resBody) : resBody;
                })
              )
              .subscribe((concatRes: ICopAccountDetails[]) => {
                this.copaccountdetails = concatRes;
              });
          }
        });
    });
  }

  updateForm(avmUser: IAvmUser): void {
    this.editForm.patchValue({
      id: avmUser.id,
      copAccountDetails: avmUser.copAccountDetails
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const avmUser = this.createFromForm();
    if (avmUser.id !== undefined) {
      this.subscribeToSaveResponse(this.avmUserService.update(avmUser));
    } else {
      this.subscribeToSaveResponse(this.avmUserService.create(avmUser));
    }
  }

  private createFromForm(): IAvmUser {
    return {
      ...new AvmUser(),
      id: this.editForm.get(['id'])!.value,
      copAccountDetails: this.editForm.get(['copAccountDetails'])!.value
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IAvmUser>>): void {
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

  trackById(index: number, item: ICopAccountDetails): any {
    return item.id;
  }
}
