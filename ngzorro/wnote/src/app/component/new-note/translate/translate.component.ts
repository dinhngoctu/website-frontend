import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-translate',
  templateUrl: './translate.component.html',
  styleUrls: ['./translate.component.css']
})
export class TranslateComponent implements OnInit {

  @Input() isVisible: boolean;
  @Output() closeModal: EventEmitter<any> = new EventEmitter();
  @Output() refresh: EventEmitter<any> = new EventEmitter();

  constructor() { }

  ngOnInit(): void {
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

}
