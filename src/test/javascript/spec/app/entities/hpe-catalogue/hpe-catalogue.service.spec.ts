import { TestBed, getTestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { take, map } from 'rxjs/operators';
import { HpeCatalogueService } from 'app/entities/hpe-catalogue/hpe-catalogue.service';
import { IHpeCatalogue, HpeCatalogue } from 'app/shared/model/hpe-catalogue.model';

describe('Service Tests', () => {
  describe('HpeCatalogue Service', () => {
    let injector: TestBed;
    let service: HpeCatalogueService;
    let httpMock: HttpTestingController;
    let elemDefault: IHpeCatalogue;
    let expectedResult: IHpeCatalogue | IHpeCatalogue[] | boolean | null;
    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [HttpClientTestingModule]
      });
      expectedResult = null;
      injector = getTestBed();
      service = injector.get(HpeCatalogueService);
      httpMock = injector.get(HttpTestingController);

      elemDefault = new HpeCatalogue(
        0,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA'
      );
    });

    describe('Service methods', () => {
      it('should find an element', () => {
        const returnedFromService = Object.assign({}, elemDefault);
        service
          .find(123)
          .pipe(take(1))
          .subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'GET' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(elemDefault);
      });

      it('should create a HpeCatalogue', () => {
        const returnedFromService = Object.assign(
          {
            id: 0
          },
          elemDefault
        );
        const expected = Object.assign({}, returnedFromService);
        service
          .create(new HpeCatalogue())
          .pipe(take(1))
          .subscribe(resp => (expectedResult = resp.body));
        const req = httpMock.expectOne({ method: 'POST' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should update a HpeCatalogue', () => {
        const returnedFromService = Object.assign(
          {
            produktNummer: 'BBBBBB',
            produktBeschreibung: 'BBBBBB',
            kurzeProduktBeschreibung: 'BBBBBB',
            produktName: 'BBBBBB',
            plBeschreibung: 'BBBBBB',
            pl: 'BBBBBB',
            land: 'BBBBBB',
            wahrung: 'BBBBBB',
            incoterm: 'BBBBBB',
            preisStatus: 'BBBBBB',
            datumPreisanderung: 'BBBBBB',
            aktuellerListenPreis: 'BBBBBB',
            aktuellerListenpreisGultig: 'BBBBBB',
            vorherigerListenpreis: 'BBBBBB',
            nettoPreis: 'BBBBBB',
            gultigkeitsDatumNettopreis: 'BBBBBB',
            vorherigerNettoPreis: 'BBBBBB',
            paNachlass: 'BBBBBB',
            exhibit: 'BBBBBB',
            uom: 'BBBBBB',
            preisstaffelVon: 'BBBBBB',
            preisstaffelBis: 'BBBBBB',
            eoq: 'BBBBBB',
            plcStatus: 'BBBBBB',
            plcGultigkeitsdatum: 'BBBBBB',
            ersatzProdukt: 'BBBBBB',
            marketingProgramm: 'BBBBBB',
            gewahrleistung: 'BBBBBB',
            classDescription: 'BBBBBB',
            classCode: 'BBBBBB',
            produktFamilienBeschreibung: 'BBBBBB',
            produktFamilie: 'BBBBBB',
            serienBeschreibung: 'BBBBBB',
            seriesCode: 'BBBBBB',
            modellBeschreibung: 'BBBBBB',
            modell: 'BBBBBB',
            standardLieferzeitDistributoren: 'BBBBBB',
            volumen: 'BBBBBB',
            volumenEinheit: 'BBBBBB',
            bruttogewichtProdukts: 'BBBBBB',
            gewichtseinheit: 'BBBBBB',
            produktabmessungen: 'BBBBBB',
            maSeinheit: 'BBBBBB',
            eanCode: 'BBBBBB',
            serialisierungsKennung: 'BBBBBB',
            paNummer: 'BBBBBB',
            partnerName: 'BBBBBB',
            partnerPro: 'BBBBBB',
            datumsUhrzeitstempel: 'BBBBBB'
          },
          elemDefault
        );

        const expected = Object.assign({}, returnedFromService);
        service
          .update(expected)
          .pipe(take(1))
          .subscribe(resp => (expectedResult = resp.body));
        const req = httpMock.expectOne({ method: 'PUT' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should return a list of HpeCatalogue', () => {
        const returnedFromService = Object.assign(
          {
            produktNummer: 'BBBBBB',
            produktBeschreibung: 'BBBBBB',
            kurzeProduktBeschreibung: 'BBBBBB',
            produktName: 'BBBBBB',
            plBeschreibung: 'BBBBBB',
            pl: 'BBBBBB',
            land: 'BBBBBB',
            wahrung: 'BBBBBB',
            incoterm: 'BBBBBB',
            preisStatus: 'BBBBBB',
            datumPreisanderung: 'BBBBBB',
            aktuellerListenPreis: 'BBBBBB',
            aktuellerListenpreisGultig: 'BBBBBB',
            vorherigerListenpreis: 'BBBBBB',
            nettoPreis: 'BBBBBB',
            gultigkeitsDatumNettopreis: 'BBBBBB',
            vorherigerNettoPreis: 'BBBBBB',
            paNachlass: 'BBBBBB',
            exhibit: 'BBBBBB',
            uom: 'BBBBBB',
            preisstaffelVon: 'BBBBBB',
            preisstaffelBis: 'BBBBBB',
            eoq: 'BBBBBB',
            plcStatus: 'BBBBBB',
            plcGultigkeitsdatum: 'BBBBBB',
            ersatzProdukt: 'BBBBBB',
            marketingProgramm: 'BBBBBB',
            gewahrleistung: 'BBBBBB',
            classDescription: 'BBBBBB',
            classCode: 'BBBBBB',
            produktFamilienBeschreibung: 'BBBBBB',
            produktFamilie: 'BBBBBB',
            serienBeschreibung: 'BBBBBB',
            seriesCode: 'BBBBBB',
            modellBeschreibung: 'BBBBBB',
            modell: 'BBBBBB',
            standardLieferzeitDistributoren: 'BBBBBB',
            volumen: 'BBBBBB',
            volumenEinheit: 'BBBBBB',
            bruttogewichtProdukts: 'BBBBBB',
            gewichtseinheit: 'BBBBBB',
            produktabmessungen: 'BBBBBB',
            maSeinheit: 'BBBBBB',
            eanCode: 'BBBBBB',
            serialisierungsKennung: 'BBBBBB',
            paNummer: 'BBBBBB',
            partnerName: 'BBBBBB',
            partnerPro: 'BBBBBB',
            datumsUhrzeitstempel: 'BBBBBB'
          },
          elemDefault
        );
        const expected = Object.assign({}, returnedFromService);
        service
          .query()
          .pipe(
            take(1),
            map(resp => resp.body)
          )
          .subscribe(body => (expectedResult = body));
        const req = httpMock.expectOne({ method: 'GET' });
        req.flush([returnedFromService]);
        httpMock.verify();
        expect(expectedResult).toContainEqual(expected);
      });

      it('should delete a HpeCatalogue', () => {
        service.delete(123).subscribe(resp => (expectedResult = resp.ok));

        const req = httpMock.expectOne({ method: 'DELETE' });
        req.flush({ status: 200 });
        expect(expectedResult);
      });
    });

    afterEach(() => {
      httpMock.verify();
    });
  });
});
