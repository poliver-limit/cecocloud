import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';

import { MdcWebMaterialModule } from '../../shared/mdc-web-material.module';
import { MarcatgeRoutingModule } from './marcatge.routing';

import { CreateMarcatgeComponent } from './createMarcatge.component';
import { FormsModule } from '@angular/forms';

@NgModule( {
    imports: [
        CommonModule,
        TranslateModule,
        MdcWebMaterialModule,
        FormsModule,
        MarcatgeRoutingModule
    ],
    declarations: [
        CreateMarcatgeComponent]
} )
export class MarcatgeModule { }