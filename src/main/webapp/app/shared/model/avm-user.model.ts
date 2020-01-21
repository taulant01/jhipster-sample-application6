import { ICopAccountDetails } from 'app/shared/model/cop-account-details.model';

export interface IAvmUser {
  id?: number;
  copAccountDetails?: ICopAccountDetails;
}

export class AvmUser implements IAvmUser {
  constructor(public id?: number, public copAccountDetails?: ICopAccountDetails) {}
}
