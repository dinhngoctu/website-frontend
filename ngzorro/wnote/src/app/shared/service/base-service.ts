import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {AppConsts} from '../app-constant';

@Injectable()
export class BaseService {

  constructor(
    public httpClient: HttpClient,
    protected configService: AppConsts
  ) {
  }
  get(url: string, params?: {}, responseType?: string): Observable<any> {
    switch (responseType) {
      case 'text':
        return this.httpClient.get(this.configService.baseUrl + url, {
          headers: this.createHeaders().set('skipLoading', 'true') || {},
          params,
          responseType: 'text',
        });
      case 'blob':
        return this.httpClient.get(this.configService.baseUrl + url, {
          headers: this.createHeaders().set('skipLoading', 'true') || {},
          params,
          responseType: 'blob',
        });
      default:
        return this.httpClient.get(this.configService.baseUrl + url, {
          headers: this.createHeaders().set('skipLoading', 'true') || {},
          params
        });
    }
  }
  async getWithAsync(url: string, params?: {}, responseType?: string) {
    switch (responseType) {
      case 'text':
        return await this.httpClient.get(this.configService.baseUrl + url, {
          headers: this.createHeaders().set('skipLoading', 'true') || {},
          params,
          responseType: 'text',
        }).toPromise();
      case 'blob':
        return await this.httpClient.get(this.configService.baseUrl + url, {
          headers: this.createHeaders().set('skipLoading', 'true') || {},
          params,
          responseType: 'blob',
        }).toPromise();
      case 'arraybuffer':
        return await this.httpClient.post(this.configService.baseUrl + url, {
          headers: this.createHeaders() || {},
          responseType: 'arraybuffer',
          params
        }).toPromise();
      default:
        return await this.httpClient.get(this.configService.baseUrl + url, {
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
        return this.httpClient.post(this.configService.baseUrl + url, data, {
          headers: this.createHeaders().set('skipLoading', 'true') || {},
          responseType: 'text',
          params
        });
      case 'blob':
        return this.httpClient.post(this.configService.baseUrl + url, data, {
          headers: this.createHeaders().set('skipLoading', 'true') || {},
          responseType: 'blob',
          params
        });
      default:
        return this.httpClient.post(this.configService.baseUrl + url, data, {
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
        return this.httpClient.put(this.configService.baseUrl + url, data, {
          headers: this.createHeaders() || {},
          responseType: 'text'
        });
      default:
        return this.httpClient.put(this.configService.baseUrl + url, data, {
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
        return this.httpClient.delete(this.configService.baseUrl + url, {
          headers: this.createHeaders() || {},
          responseType: 'text'
        });
      default:
        return this.httpClient.delete(this.configService.baseUrl + url, {
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
