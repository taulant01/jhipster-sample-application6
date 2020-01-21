import { IKalkulationDetails } from 'app/shared/model/kalkulation-details.model';
import { IUser } from 'app/core/user/user.model';
import { Status } from 'app/shared/model/enumerations/status.model';

export interface IKalkulation {
  id?: number;
  kalkId?: number;
  version?: number;
  status?: Status;
  editing?: boolean;
  kalkulationDetails?: IKalkulationDetails[];
  user?: IUser;
}

export class Kalkulation implements IKalkulation {
  constructor(
    public id?: number,
    public kalkId?: number,
    public version?: number,
    public status?: Status,
    public editing?: boolean,
    public kalkulationDetails?: IKalkulationDetails[],
    public user?: IUser
  ) {
    this.editing = this.editing || false;
  }
}
