import {NgModule, NO_ERRORS_SCHEMA} from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {NZ_I18N, NzI18nModule} from 'ng-zorro-antd/i18n';
import { en_US } from 'ng-zorro-antd/i18n';
import { registerLocaleData } from '@angular/common';
import en from '@angular/common/locales/en';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { IconsProviderModule } from './icons-provider.module';
import { NzLayoutModule } from 'ng-zorro-antd/layout';
import { NzMenuModule } from 'ng-zorro-antd/menu';
import { NzGridModule } from 'ng-zorro-antd/grid';
import { QuillInputComponent } from './editor/quill-input/quill-input.component';
import {QuillModule} from 'ngx-quill';
import { NzDividerModule } from 'ng-zorro-antd/divider';
import {NzEmptyModule} from 'ng-zorro-antd/empty';
import {NzTimelineModule} from 'ng-zorro-antd/timeline';
import {NzStepsModule} from 'ng-zorro-antd/steps';
import {NzPopoverModule} from 'ng-zorro-antd/popover';
import {NzModalModule} from 'ng-zorro-antd/modal';
import {NzFormModule} from 'ng-zorro-antd/form';
import { NewNoteComponent } from './component/new-note/new-note.component';
import { TranslateComponent } from './component/new-note/translate/translate.component';
import {NzTableModule} from 'ng-zorro-antd/table';
import { ListNoteComponent } from './component/list-note/list-note.component';

registerLocaleData(en);

@NgModule({
  schemas: [ NO_ERRORS_SCHEMA ],
  declarations: [
    AppComponent,
    QuillInputComponent,
    NewNoteComponent,
    TranslateComponent,
    ListNoteComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    IconsProviderModule,
    NzLayoutModule,
    NzI18nModule,
    NzModalModule,
    NzTableModule,
    NzFormModule,
    NzEmptyModule,
    NzGridModule,
    NzDividerModule,
    NzMenuModule,
    NzTimelineModule,
    NzStepsModule,
    NzPopoverModule,
    HttpClientModule,
    QuillModule
      .forRoot({
        theme: 'bubble',
        placeholder: '     input here... ',
      modules: {
        syntax: true,
        toolbar: [
          // ['bold', 'italic', 'underline', 'strike'],        // toggled buttons
          ['bold', 'italic'],        // toggled buttons
          ['blockquote', 'code-block'],

          [{ 'header': 1 }, { 'header': 2 }],               // custom button values
          [{ 'list': 'ordered'}, { 'list': 'bullet' }],
          // [{ 'script': 'sub'}, { 'script': 'super' }],      // superscript/subscript
          [ { 'script': 'super' }],      // superscript/subscript
          [{ 'indent': '-1'}, { 'indent': '+1' }],          // outdent/indent
          [{ 'direction': 'rtl' }],                         // text direction

          [{ 'size': ['small', false, 'large', 'huge'] }],  // custom dropdown
          [{ 'header': [1, 2, 3, 4, 5, 6, false] }],

          // [{ 'color': [] }, { 'background': [] }],          // dropdown with defaults from theme
          [{ 'font': [] }],
          [{ 'align': [] }],

          ['clean'],                                         // remove formatting button

          ['link', 'image', 'video']                         // link and image, video
        ]
      }
    })
  ],
  providers: [{ provide: NZ_I18N, useValue: en_US }],
  bootstrap: [AppComponent]
})
export class AppModule { }
