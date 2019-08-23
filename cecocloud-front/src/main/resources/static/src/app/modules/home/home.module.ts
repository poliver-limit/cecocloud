import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';

import { MantenimentModule } from '../../shared/manteniment.module';
import { MdcWebModule } from '../../shared/mdc-web.module';
import { HomeComponent } from './home.component';

@NgModule( {
    imports: [
        CommonModule,
        TranslateModule,
        MdcWebModule,
        RouterModule.forChild( [
            { path: '', component: HomeComponent }
        ] )
    ],
    declarations: [
        HomeComponent
    ]
} )
export class HomeModule {}