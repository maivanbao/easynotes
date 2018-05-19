import { Injectable } from '@angular/core';
import { Http, Headers, Request, RequestOptions, RequestMethod, Response } from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import { environment } from '../../environments/environment';
import { Observable } from 'rxjs';
import { API_BASE_URL } from './../constants/index';
@Injectable()
export class ApiService {
  // private baseUrl = environment.apiUrl;
  private baseUrl = API_BASE_URL;
  constructor(private http: Http) { }
  get(url: string) {
    return this.request(url, RequestMethod.Get);
  }

  post(url: string, body: Object) {
    return this.request(url, RequestMethod.Post, body);
  }

  put(url: string, body: Object) {
    return this.request(url, RequestMethod.Put, body);
  }

  delete(url: string) {
    return this.request(url, RequestMethod.Delete);
  }
  request(url: String, method: RequestMethod, body?: Object) {
    const headers = new Headers();
    headers.append('Content-type', 'application/json');
    if (localStorage.getItem('token')) {
      headers.append('Authorization', 'Bearer ' + localStorage.getItem('token'))
    }
    const requestOptions = new RequestOptions({
      url: `${this.baseUrl}/${url}`,
      method: method,
      headers: headers
    });
    if (body) {
      requestOptions.body = body;
    }
    const request = new Request(requestOptions);

    return this.http.request(request).toPromise()
      .then((res: Response) => res.json())
      //  .map((res: Response) => res.json())
      .catch((res: Response) => this.onRequestError(res));
  }
  onRequestError(res: Response) {
    const statusCode = res.status;
    const body = res.json();
    const error = {
      statusCode: statusCode,
      error: body.error
    }
    console.log(error);
    return Observable.throw(error);
  }
}