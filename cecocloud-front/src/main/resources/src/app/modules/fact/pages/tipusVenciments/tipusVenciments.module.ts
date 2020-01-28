import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { TipusVencimentsGridComponent } from './tipusVenciments-grid.component';
import { TipusVencimentsFormComponent } from './tipusVenciments-form.component';
import { TipusVencimentsService } from './tipusVenciments.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: TipusVencimentsGridComponent },
            { path: 'create', component: TipusVencimentsFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: TipusVencimentsFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        TipusVencimentsGridComponent,
        TipusVencimentsFormComponent
    ],
    providers: [
        TipusVencimentsService
    ]
} )
export class TipusVencimentsModule {}