import {Component, OnDestroy, OnInit} from '@angular/core';

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

}
