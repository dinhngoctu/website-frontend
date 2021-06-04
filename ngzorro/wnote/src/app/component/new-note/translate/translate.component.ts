import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-translate',
  templateUrl: './translate.component.html',
  styleUrls: ['./translate.component.css']
})
export class TranslateComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }


  handleOk(): void {
    console.log('Button ok clicked!');
  }

  handleCancel(): void {
    console.log('Button cancel clicked!');
  }

}
