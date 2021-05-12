import {Component, OnDestroy, OnInit} from '@angular/core';
import EditorJS from '@editorjs/editorjs';
import Header from '@editorjs/header';
import {Editor} from 'ngx-editor';

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
  isCollapsedCate = false;
  isReverseArrow = false;
  editor = new Editor();
  // editor = new EditorJS({
  //   holderId: 'editorjs',
  //   tools: {
  //     header: {
  //       class: Header,
  //       inlineToolbar: true
  //     }
  //   }
  // });

}
