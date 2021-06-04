import { Component, OnInit } from '@angular/core';
import {NzButtonSize} from 'ng-zorro-antd/button';

@Component({
  selector: 'app-new-note',
  templateUrl: './new-note.component.html',
  styleUrls: ['./new-note.component.css']
})
export class NewNoteComponent implements OnInit {

  constructor() { }
  isCollapsed = true;
  isCollapsed2 = true;
  switch3 = false;
  isCollapsedCate = false;
  isReverseArrow = false;
  size: NzButtonSize = 'small';

  isVisible = false;
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
  showModal(): void {
    this.isVisible = true;
  }

}
