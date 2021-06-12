import { Component, OnInit } from '@angular/core';
import {NzModalService} from 'ng-zorro-antd/modal';
import {NzButtonSize} from 'ng-zorro-antd/button';


interface ItemData {
  href: string;
  title: string;
  avatar: string;
  description: string;
  content: string;
}
@Component({
  selector: 'app-list-note',
  templateUrl: './list-note.component.html',
  styleUrls: ['./list-note.component.css']
})
export class ListNoteComponent implements OnInit {

  constructor(private modalService: NzModalService) { }
  isCollapsed = true;
  isCollapsed2 = true;
  switch3 = false;
  isCollapsedCate = false;
  isReverseArrow = false;
  size: NzButtonSize = 'small';
  data: ItemData[] = [];

  isVisible = false;
  // tslint:disable-next-line:use-lifecycle-interface
  ngOnDestroy(): void {
  }
  ngOnInit(): void {
    this.loadData(1);
  }

  loadData(pi: number): void {
    this.data = new Array(5).fill({}).map((_, index) => {
      return {
        href: 'http://ant.design',
        title: `ant design part ${index} (page: ${pi})`,
        avatar: 'https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png',
        description: 'Ant Design, a design language for background applications, is refined by Ant UED Team.',
        content:
          'We supply a series of design principles, practical patterns and high quality design resources ' +
          '(Sketch and Axure), to help people create their product prototypes beautifully and efficiently.'
      };
    });
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
