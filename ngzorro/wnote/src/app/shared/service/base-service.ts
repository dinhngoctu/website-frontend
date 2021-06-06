import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {AppConsts} from '../app-constant';
import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class BaseService {
  baseUrl = 'http://192.168.1.7:6001';
  protected configService = new AppConsts();
  constructor(
    public httpClient: HttpClient) {
  }
  get(url: string, params?: {}, responseType?: string): Observable<any> {
    switch (responseType) {
      case 'text':
        return this.httpClient.get(this.baseUrl + url, {
          headers: this.createHeaders().set('skipLoading', 'true') || {},
          params,
          responseType: 'text',
        });
      case 'blob':
        return this.httpClient.get(this.baseUrl + url, {
          headers: this.createHeaders().set('skipLoading', 'true') || {},
          params,
          responseType: 'blob',
        });
      default:
        return this.httpClient.get(this.baseUrl + url, {
          headers: this.createHeaders().set('skipLoading', 'true') || {},
          params
        });
    }
  }
  async getWithAsync(url: string, params?: {}, responseType?: string) {
    switch (responseType) {
      case 'text':
        return await this.httpClient.get(this.baseUrl + url, {
          headers: this.createHeaders().set('skipLoading', 'true') || {},
          params,
          responseType: 'text',
        }).toPromise();
      case 'blob':
        return await this.httpClient.get(this.baseUrl + url, {
          headers: this.createHeaders().set('skipLoading', 'true') || {},
          params,
          responseType: 'blob',
        }).toPromise();
      case 'arraybuffer':
        return await this.httpClient.post(this.baseUrl + url, {
          headers: this.createHeaders() || {},
          responseType: 'arraybuffer',
          params
        }).toPromise();
      default:
        return await this.httpClient.get(this.baseUrl + url, {
          headers: this.createHeaders().set('skipLoading', 'true') || {},
          params
        }).toPromise();
    }
  }
  /**
   * Create a new entity.
   * @param url the api url
   * @param data the entity to create
   */
  post(url: string, data: any, params?: {}, responseType?: string): Observable<any> {
    switch (responseType) {
      case 'text':
        return this.httpClient.post(this.baseUrl + url, data, {
          headers: this.createHeaders().set('skipLoading', 'true') || {},
          responseType: 'text',
          params
        });
      case 'blob':
        return this.httpClient.post(this.baseUrl + url, data, {
          headers: this.createHeaders().set('skipLoading', 'true') || {},
          responseType: 'blob',
          params
        });
      default:
        return this.httpClient.post(this.baseUrl + url, data, {
          headers: this.createHeaders().set('skipLoading', 'true') || {},
          params
        });
    }
  }

  /**
   * Update an entity.
   * @param url the api url
   * @param data the entity to be updated
   */
  put(url: string, data: any, responseType?: string): Observable<any> {
    switch (responseType) {
      case 'text':
        return this.httpClient.put(this.baseUrl + url, data, {
          headers: this.createHeaders() || {},
          responseType: 'text'
        });
      default:
        return this.httpClient.put(this.baseUrl + url, data, {
          headers: this.createHeaders() || {},
        });
    }
  }

  /**
   * Delete an entity.
   * @param url the api url
   * @param id the entity id to be deleted
   */
  delete(url: string, id: any, responseType?: string): Observable<any> {
    switch (responseType) {
      case 'text':
        return this.httpClient.delete(this.baseUrl + url, {
          headers: this.createHeaders() || {},
          responseType: 'text'
        });
      default:
        return this.httpClient.delete(this.baseUrl + url, {
          headers: this.createHeaders() || {},
        });
    }
  }

  public createHeaders() {
    // Why "authorization": see CustomLogoutSuccessHandler on server
    return new HttpHeaders().set('Authorization', 'Bearer ' + this.getToken());
  }
  private getToken() {
    // return localStorage.getItem(Constant.TOKEN);
  }
}
