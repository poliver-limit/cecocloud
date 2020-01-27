import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';

import { MaterialModule } from '../../../../shared/material.module';

import { IndexComponent } from './index.component';

@NgModule( {
    imports: [
        CommonModule,
        TranslateModule,
        MaterialModule,
        RouterModule.forChild( [
            { path: '', component: IndexComponent }
        ] )
    ],
    declarations: [
        IndexComponent
    ]
} )
export class IndexModule {}