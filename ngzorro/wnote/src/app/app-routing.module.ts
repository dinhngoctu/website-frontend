import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {NewNoteComponent} from './component/new-note/new-note.component';
import {ListNoteComponent} from './component/list-note/list-note.component';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: '/new-note' },
  { path: 'new-note', component: NewNoteComponent},
  { path: 'list-note', component: ListNoteComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
