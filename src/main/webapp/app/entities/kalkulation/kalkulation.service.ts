import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { IKalkulation } from 'app/shared/model/kalkulation.model';

type EntityResponseType = HttpResponse<IKalkulation>;
type EntityArrayResponseType = HttpResponse<IKalkulation[]>;

@Injectable({ providedIn: 'root' })
export class KalkulationService {
  public resourceUrl = SERVER_API_URL + 'api/kalkulations';

  constructor(protected http: HttpClient) {}

  create(kalkulation: IKalkulation): Observable<EntityResponseType> {
    return this.http.post<IKalkulation>(this.resourceUrl, kalkulation, { observe: 'response' });
  }

  update(kalkulation: IKalkulation): Observable<EntityResponseType> {
    return this.http.put<IKalkulation>(this.resourceUrl, kalkulation, { observe: 'response' });
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http.get<IKalkulation>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<IKalkulation[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }
}
