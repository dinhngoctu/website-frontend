import {Component, OnDestroy, OnInit} from '@angular/core';
import {NzButtonSize} from 'ng-zorro-antd/button';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit, OnDestroy{
  ngOnDestroy(): void {
  }
  ngOnInit(): void {
  }
  isCollapsed = true;
  isCollapsed2 = true;
  switch3 = false;
  isCollapsedCate = false;
  isReverseArrow = false;
  size: NzButtonSize = 'small';

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

}
