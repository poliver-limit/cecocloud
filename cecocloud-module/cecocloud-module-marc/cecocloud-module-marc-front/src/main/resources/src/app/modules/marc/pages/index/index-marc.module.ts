import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';

import { MaterialModule } from '../../../../shared/material.module';
import { IndexMarcComponent } from './index-marc.component';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
        MaterialModule,
        RouterModule.forChild( [
            { path: '', component: IndexMarcComponent }
        ] )
    ],
    declarations: [
        IndexMarcComponent
    ]
} )
export class IndexMarcModule {

}