import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { ICopAccountDetails } from 'app/shared/model/cop-account-details.model';

type EntityResponseType = HttpResponse<ICopAccountDetails>;
type EntityArrayResponseType = HttpResponse<ICopAccountDetails[]>;

@Injectable({ providedIn: 'root' })
export class CopAccountDetailsService {
  public resourceUrl = SERVER_API_URL + 'api/cop-account-details';

  constructor(protected http: HttpClient) {}

  create(copAccountDetails: ICopAccountDetails): Observable<EntityResponseType> {
    return this.http.post<ICopAccountDetails>(this.resourceUrl, copAccountDetails, { observe: 'response' });
  }

  update(copAccountDetails: ICopAccountDetails): Observable<EntityResponseType> {
    return this.http.put<ICopAccountDetails>(this.resourceUrl, copAccountDetails, { observe: 'response' });
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http.get<ICopAccountDetails>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<ICopAccountDetails[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }
}
