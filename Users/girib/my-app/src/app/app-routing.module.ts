import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TableDetailsComponent } from './table-details/table-details.component';
import { TableFieldDetailsComponent } from './table-field-details/table-field-details.component';

const routes: Routes = [
  {path:'tables',component:TableDetailsComponent},
  {path:'table-fields/:table',component:TableFieldDetailsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
