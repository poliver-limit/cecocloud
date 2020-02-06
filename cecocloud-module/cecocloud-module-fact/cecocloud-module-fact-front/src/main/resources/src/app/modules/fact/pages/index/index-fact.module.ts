import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';

import { MaterialModule } from '../../../../shared/material.module';

import { IndexFactComponent } from './index-fact.component';

@NgModule( {
    imports: [
        CommonModule,
        TranslateModule,
        MaterialModule,
        RouterModule.forChild( [
            { path: '', component: IndexFactComponent }
        ] )
    ],
    declarations: [
        IndexFactComponent
    ]
} )
export class IndexFactModule {}