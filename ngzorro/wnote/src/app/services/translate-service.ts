import {Injectable} from '@angular/core';
import {BaseService} from '../shared/service/base-service';

@Injectable()
export class TranslateService extends BaseService {
  getListWords(){
    return this.get("/dict/list/")
  }
}
