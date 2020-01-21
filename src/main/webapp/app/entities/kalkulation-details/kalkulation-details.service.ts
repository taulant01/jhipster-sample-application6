import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { IKalkulationDetails } from 'app/shared/model/kalkulation-details.model';

type EntityResponseType = HttpResponse<IKalkulationDetails>;
type EntityArrayResponseType = HttpResponse<IKalkulationDetails[]>;

@Injectable({ providedIn: 'root' })
export class KalkulationDetailsService {
  public resourceUrl = SERVER_API_URL + 'api/kalkulation-details';

  constructor(protected http: HttpClient) {}

  create(kalkulationDetails: IKalkulationDetails): Observable<EntityResponseType> {
    return this.http.post<IKalkulationDetails>(this.resourceUrl, kalkulationDetails, { observe: 'response' });
  }

  update(kalkulationDetails: IKalkulationDetails): Observable<EntityResponseType> {
    return this.http.put<IKalkulationDetails>(this.resourceUrl, kalkulationDetails, { observe: 'response' });
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http.get<IKalkulationDetails>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<IKalkulationDetails[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }
}
