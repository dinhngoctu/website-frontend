import { Component } from '@angular/core';
import {Editor} from 'ngx-editor';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  isCollapsed = true;
  isCollapsed2 = true;
  isCollapsedCate = false;
  isReverseArrow = false;
  editor = new Editor();
}
