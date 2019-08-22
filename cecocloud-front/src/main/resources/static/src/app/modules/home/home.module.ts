import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';

import { MantenimentModule } from '../../shared/manteniment.module';
import { MdcWebMaterialModule } from '../../shared/mdc-web-material.module';
import { HomeComponent } from './home.component';

@NgModule( {
    imports: [
        CommonModule,
        TranslateModule,
        MdcWebMaterialModule,
        RouterModule.forChild( [
            { path: '', component: HomeComponent }
        ] )
    ],
    declarations: [
        HomeComponent
    ]
} )
export class HomeModule {}