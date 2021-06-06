import {Injectable} from '@angular/core';
import {BaseService} from '../shared/service/base-service';
import {TranslateWordsRequest} from '../model/request/translate-words-request';

@Injectable({
  providedIn: 'root'
})
export class TranslateService extends BaseService {
  getListWords(){
    return this.get('/dict/list/');
  }
  translateWord(request: TranslateWordsRequest){
    return this.post('/dict/translate', request);
  }
}
