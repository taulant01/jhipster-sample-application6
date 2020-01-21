export interface IHpeCatalogue {
  id?: number;
  produktNummer?: string;
  produktBeschreibung?: string;
  kurzeProduktBeschreibung?: string;
  produktName?: string;
  plBeschreibung?: string;
  pl?: string;
  land?: string;
  wahrung?: string;
  incoterm?: string;
  preisStatus?: string;
  datumPreisanderung?: string;
  aktuellerListenPreis?: string;
  aktuellerListenpreisGultig?: string;
  vorherigerListenpreis?: string;
  nettoPreis?: string;
  gultigkeitsDatumNettopreis?: string;
  vorherigerNettoPreis?: string;
  paNachlass?: string;
  exhibit?: string;
  uom?: string;
  preisstaffelVon?: string;
  preisstaffelBis?: string;
  eoq?: string;
  plcStatus?: string;
  plcGultigkeitsdatum?: string;
  ersatzProdukt?: string;
  marketingProgramm?: string;
  gewahrleistung?: string;
  classDescription?: string;
  classCode?: string;
  produktFamilienBeschreibung?: string;
  produktFamilie?: string;
  serienBeschreibung?: string;
  seriesCode?: string;
  modellBeschreibung?: string;
  modell?: string;
  standardLieferzeitDistributoren?: string;
  volumen?: string;
  volumenEinheit?: string;
  bruttogewichtProdukts?: string;
  gewichtseinheit?: string;
  produktabmessungen?: string;
  maSeinheit?: string;
  eanCode?: string;
  serialisierungsKennung?: string;
  paNummer?: string;
  partnerName?: string;
  partnerPro?: string;
  datumsUhrzeitstempel?: string;
}

export class HpeCatalogue implements IHpeCatalogue {
  constructor(
    public id?: number,
    public produktNummer?: string,
    public produktBeschreibung?: string,
    public kurzeProduktBeschreibung?: string,
    public produktName?: string,
    public plBeschreibung?: string,
    public pl?: string,
    public land?: string,
    public wahrung?: string,
    public incoterm?: string,
    public preisStatus?: string,
    public datumPreisanderung?: string,
    public aktuellerListenPreis?: string,
    public aktuellerListenpreisGultig?: string,
    public vorherigerListenpreis?: string,
    public nettoPreis?: string,
    public gultigkeitsDatumNettopreis?: string,
    public vorherigerNettoPreis?: string,
    public paNachlass?: string,
    public exhibit?: string,
    public uom?: string,
    public preisstaffelVon?: string,
    public preisstaffelBis?: string,
    public eoq?: string,
    public plcStatus?: string,
    public plcGultigkeitsdatum?: string,
    public ersatzProdukt?: string,
    public marketingProgramm?: string,
    public gewahrleistung?: string,
    public classDescription?: string,
    public classCode?: string,
    public produktFamilienBeschreibung?: string,
    public produktFamilie?: string,
    public serienBeschreibung?: string,
    public seriesCode?: string,
    public modellBeschreibung?: string,
    public modell?: string,
    public standardLieferzeitDistributoren?: string,
    public volumen?: string,
    public volumenEinheit?: string,
    public bruttogewichtProdukts?: string,
    public gewichtseinheit?: string,
    public produktabmessungen?: string,
    public maSeinheit?: string,
    public eanCode?: string,
    public serialisierungsKennung?: string,
    public paNummer?: string,
    public partnerName?: string,
    public partnerPro?: string,
    public datumsUhrzeitstempel?: string
  ) {}
}
