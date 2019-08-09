import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreateMarcatgeComponent } from './createMarcatge.component';

const routes: Routes = [{
    path: '',
    component: CreateMarcatgeComponent
}];

@NgModule( {
    imports: [RouterModule.forChild( routes )],
    exports: [RouterModule]
} )
export class MarcatgeRoutingModule { }
