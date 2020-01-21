import { IKalkulation } from 'app/shared/model/kalkulation.model';

export interface IKalkulationDetails {
  id?: number;
  a?: string;
  b?: string;
  c?: string;
  d?: string;
  e?: string;
  f?: string;
  g?: string;
  h?: string;
  i?: string;
  j?: string;
  k?: string;
  l?: string;
  m?: string;
  n?: string;
  o?: string;
  p?: string;
  q?: string;
  r?: string;
  s?: string;
  t?: string;
  u?: string;
  v?: string;
  w?: string;
  x?: string;
  y?: string;
  z?: string;
  aa?: string;
  ab?: string;
  ac?: string;
  ad?: string;
  ae?: string;
  af?: string;
  ag?: string;
  kalkulation?: IKalkulation;
}

export class KalkulationDetails implements IKalkulationDetails {
  constructor(
    public id?: number,
    public a?: string,
    public b?: string,
    public c?: string,
    public d?: string,
    public e?: string,
    public f?: string,
    public g?: string,
    public h?: string,
    public i?: string,
    public j?: string,
    public k?: string,
    public l?: string,
    public m?: string,
    public n?: string,
    public o?: string,
    public p?: string,
    public q?: string,
    public r?: string,
    public s?: string,
    public t?: string,
    public u?: string,
    public v?: string,
    public w?: string,
    public x?: string,
    public y?: string,
    public z?: string,
    public aa?: string,
    public ab?: string,
    public ac?: string,
    public ad?: string,
    public ae?: string,
    public af?: string,
    public ag?: string,
    public kalkulation?: IKalkulation
  ) {}
}
