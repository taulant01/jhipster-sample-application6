export interface ICopAccountDetails {
  id?: number;
  copUser?: string;
  copPassword?: string;
  copName?: string;
}

export class CopAccountDetails implements ICopAccountDetails {
  constructor(public id?: number, public copUser?: string, public copPassword?: string, public copName?: string) {}
}
