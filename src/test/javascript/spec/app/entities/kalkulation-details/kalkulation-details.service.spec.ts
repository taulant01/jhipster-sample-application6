import { TestBed, getTestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { take, map } from 'rxjs/operators';
import { KalkulationDetailsService } from 'app/entities/kalkulation-details/kalkulation-details.service';
import { IKalkulationDetails, KalkulationDetails } from 'app/shared/model/kalkulation-details.model';

describe('Service Tests', () => {
  describe('KalkulationDetails Service', () => {
    let injector: TestBed;
    let service: KalkulationDetailsService;
    let httpMock: HttpTestingController;
    let elemDefault: IKalkulationDetails;
    let expectedResult: IKalkulationDetails | IKalkulationDetails[] | boolean | null;
    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [HttpClientTestingModule]
      });
      expectedResult = null;
      injector = getTestBed();
      service = injector.get(KalkulationDetailsService);
      httpMock = injector.get(HttpTestingController);

      elemDefault = new KalkulationDetails(
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

      it('should create a KalkulationDetails', () => {
        const returnedFromService = Object.assign(
          {
            id: 0
          },
          elemDefault
        );
        const expected = Object.assign({}, returnedFromService);
        service
          .create(new KalkulationDetails())
          .pipe(take(1))
          .subscribe(resp => (expectedResult = resp.body));
        const req = httpMock.expectOne({ method: 'POST' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should update a KalkulationDetails', () => {
        const returnedFromService = Object.assign(
          {
            a: 'BBBBBB',
            b: 'BBBBBB',
            c: 'BBBBBB',
            d: 'BBBBBB',
            e: 'BBBBBB',
            f: 'BBBBBB',
            g: 'BBBBBB',
            h: 'BBBBBB',
            i: 'BBBBBB',
            j: 'BBBBBB',
            k: 'BBBBBB',
            l: 'BBBBBB',
            m: 'BBBBBB',
            n: 'BBBBBB',
            o: 'BBBBBB',
            p: 'BBBBBB',
            q: 'BBBBBB',
            r: 'BBBBBB',
            s: 'BBBBBB',
            t: 'BBBBBB',
            u: 'BBBBBB',
            v: 'BBBBBB',
            w: 'BBBBBB',
            x: 'BBBBBB',
            y: 'BBBBBB',
            z: 'BBBBBB',
            aa: 'BBBBBB',
            ab: 'BBBBBB',
            ac: 'BBBBBB',
            ad: 'BBBBBB',
            ae: 'BBBBBB',
            af: 'BBBBBB',
            ag: 'BBBBBB'
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

      it('should return a list of KalkulationDetails', () => {
        const returnedFromService = Object.assign(
          {
            a: 'BBBBBB',
            b: 'BBBBBB',
            c: 'BBBBBB',
            d: 'BBBBBB',
            e: 'BBBBBB',
            f: 'BBBBBB',
            g: 'BBBBBB',
            h: 'BBBBBB',
            i: 'BBBBBB',
            j: 'BBBBBB',
            k: 'BBBBBB',
            l: 'BBBBBB',
            m: 'BBBBBB',
            n: 'BBBBBB',
            o: 'BBBBBB',
            p: 'BBBBBB',
            q: 'BBBBBB',
            r: 'BBBBBB',
            s: 'BBBBBB',
            t: 'BBBBBB',
            u: 'BBBBBB',
            v: 'BBBBBB',
            w: 'BBBBBB',
            x: 'BBBBBB',
            y: 'BBBBBB',
            z: 'BBBBBB',
            aa: 'BBBBBB',
            ab: 'BBBBBB',
            ac: 'BBBBBB',
            ad: 'BBBBBB',
            ae: 'BBBBBB',
            af: 'BBBBBB',
            ag: 'BBBBBB'
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

      it('should delete a KalkulationDetails', () => {
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
