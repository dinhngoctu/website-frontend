import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {TranslateService} from '../../../services/translate-service';
import {da_DK} from 'ng-zorro-antd/i18n';
import {TranslateWordsRequest} from '../../../model/request/translate-words-request';


interface DataItem {
  name: string;
  chinese: number;
  math: number;
  english: number;
}
@Component({
  selector: 'app-translate',
  templateUrl: './translate.component.html',
  styleUrls: ['./translate.component.css']
})
export class TranslateComponent implements OnInit {

  @Input() isVisible: boolean;
  @Output() closeModal: EventEmitter<any> = new EventEmitter();
  @Output() refresh: EventEmitter<any> = new EventEmitter();
  listOfData: DataItem[] = [
    {
      name: 'John Brown',
      chinese: 98,
      math: 60,
      english: 70
    },
    {
      name: 'Jim Green',
      chinese: 98,
      math: 66,
      english: 89
    },
    {
      name: 'Joe Black',
      chinese: 98,
      math: 90,
      english: 70
    },
    {
      name: 'Jim Red',
      chinese: 88,
      math: 99,
      english: 89
    }
  ];
  responseWord: any;

  constructor(private translateService: TranslateService) { }

  ngOnInit(): void {
    this.getListWords();
  }


  handleOk(): void {
    console.log('Button ok clicked!');
    this.isVisible = false;
    this.closeModal.emit();
    this.refresh.emit();
  }

  handleCancel(): void {
    console.log('Button cancel clicked!');
    this.closeModal.emit();
    this.isVisible = false;
  }
  getListWords(): void{
    this.translateService.getListWords().subscribe((res) => {
      console.log(res);
      // let res1 = res.toString().replace(/(\r\n|\n|\r)/gm, '');
      this.listOfData = res;
    });
  }
  translate(){
    let searchValue = (<HTMLInputElement> document.getElementById('inputTrans')).value;
    let request = new TranslateWordsRequest();
    request.searchValue = searchValue;
    request.dict = 'en-vi';
    this.translateService.translateWord(request).subscribe((res) =>{
      this.responseWord = res.value;
      console.log(this.responseWord);
    });
  }
  getValue(str: string ): string{
    if (!str) {
      return '';
    }
    return JSON.parse(str.replace(/(\r\n|\n|\r)/gm, '')).value;
}

}
