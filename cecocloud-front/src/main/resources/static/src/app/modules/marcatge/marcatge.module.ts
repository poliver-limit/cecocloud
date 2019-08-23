import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';

import { MdcWebModule } from '../../shared/mdc-web.module';
import { MarcatgeRoutingModule } from './marcatge.routing';

import { CreateMarcatgeComponent } from './createMarcatge.component';
import { FormsModule } from '@angular/forms';

@NgModule( {
    imports: [
        CommonModule,
        TranslateModule,
        MdcWebModule,
        FormsModule,
        MarcatgeRoutingModule
    ],
    declarations: [
        CreateMarcatgeComponent]
} )
export class MarcatgeModule { }