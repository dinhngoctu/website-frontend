import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-quill-input',
  templateUrl: './quill-input.component.html',
  styleUrls: ['./quill-input.component.css']
})
export class QuillInputComponent implements OnInit {

  objectFormat = [
    { insert: '\n', attributes: { align: 'center' }  }
  ];

  options = {
    debug: 'info',
    modules: {
      toolbar: '#toolbar'
    },
    placeholder: 'Compose an epic...',
    readOnly: true,
    theme: 'snow'
  };

  constructor() { }

  ngOnInit(): void {
  }

}
