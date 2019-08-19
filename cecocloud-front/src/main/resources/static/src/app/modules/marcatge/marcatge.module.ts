import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';

import { MaterialModule } from '../../shared/material.module';
import { MarcatgeRoutingModule } from './marcatge.routing';

import { CreateMarcatgeComponent } from './createMarcatge.component';
//import {NgxMaterialTimepickerModule} from 'ngx-material-timepicker';
import { FormsModule } from '@angular/forms';
//import { BsDatepickerModule } from 'ngx-bootstrap/datepicker';

@NgModule({
    imports: [
        CommonModule,
        TranslateModule,
       FormsModule,
        MarcatgeRoutingModule,
        //NgxMaterialTimepickerModule,
        MaterialModule,
        //BsDatepickerModule.forRoot()
        ],
    declarations: [
        CreateMarcatgeComponent]
})
export class MarcatgeModule { }