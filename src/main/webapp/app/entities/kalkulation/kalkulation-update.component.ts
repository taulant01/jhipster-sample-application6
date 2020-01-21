import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { IKalkulation, Kalkulation } from 'app/shared/model/kalkulation.model';
import { KalkulationService } from './kalkulation.service';
import { IUser } from 'app/core/user/user.model';
import { UserService } from 'app/core/user/user.service';

@Component({
  selector: 'jhi-kalkulation-update',
  templateUrl: './kalkulation-update.component.html'
})
export class KalkulationUpdateComponent implements OnInit {
  isSaving = false;

  users: IUser[] = [];

  editForm = this.fb.group({
    id: [],
    kalkId: [],
    version: [],
    status: [],
    editing: [],
    user: []
  });

  constructor(
    protected kalkulationService: KalkulationService,
    protected userService: UserService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ kalkulation }) => {
      this.updateForm(kalkulation);

      this.userService
        .query()
        .pipe(
          map((res: HttpResponse<IUser[]>) => {
            return res.body ? res.body : [];
          })
        )
        .subscribe((resBody: IUser[]) => (this.users = resBody));
    });
  }

  updateForm(kalkulation: IKalkulation): void {
    this.editForm.patchValue({
      id: kalkulation.id,
      kalkId: kalkulation.kalkId,
      version: kalkulation.version,
      status: kalkulation.status,
      editing: kalkulation.editing,
      user: kalkulation.user
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const kalkulation = this.createFromForm();
    if (kalkulation.id !== undefined) {
      this.subscribeToSaveResponse(this.kalkulationService.update(kalkulation));
    } else {
      this.subscribeToSaveResponse(this.kalkulationService.create(kalkulation));
    }
  }

  private createFromForm(): IKalkulation {
    return {
      ...new Kalkulation(),
      id: this.editForm.get(['id'])!.value,
      kalkId: this.editForm.get(['kalkId'])!.value,
      version: this.editForm.get(['version'])!.value,
      status: this.editForm.get(['status'])!.value,
      editing: this.editForm.get(['editing'])!.value,
      user: this.editForm.get(['user'])!.value
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IKalkulation>>): void {
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

  trackById(index: number, item: IUser): any {
    return item.id;
  }
}
