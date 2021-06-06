import { Component, OnInit } from '@angular/core';
import {NzButtonSize} from 'ng-zorro-antd/button';
import {NzModalService} from 'ng-zorro-antd/modal';
import {TranslateComponent} from './translate/translate.component';

@Component({
  selector: 'app-new-note',
  templateUrl: './new-note.component.html',
  styleUrls: ['./new-note.component.css']
})
export class NewNoteComponent implements OnInit {

  constructor(private modalService: NzModalService) { }
  isCollapsed = true;
  isCollapsed2 = true;
  switch3 = false;
  isCollapsedCate = false;
  isReverseArrow = false;
  size: NzButtonSize = 'small';

  isVisible = false;
  // tslint:disable-next-line:use-lifecycle-interface
  ngOnDestroy(): void {
  }
  ngOnInit(): void {
  }

  switch3medthod() {
    this.switch3 = !this.switch3;
    if (this.switch3) {
      document.getElementById('extent-info-nav').className = 'col-0 ccard-shadow extent-info-nav';
      document.getElementById('content_center').className = 'col-12';
    } else {
      document.getElementById('content_center').className = 'col-9';
      document.getElementById('extent-info-nav').className = '3col-3 ccard-shadow extent-info-nav';
    }
  }
  showModal($event): void {
    this.isVisible = !this.isVisible;
  }

}
