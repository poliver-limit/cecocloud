import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../shared/material.module';

import { TipusTransaccionsGridComponent } from './tipusTransaccions-grid.component';
import { TipusTransaccionsFormComponent } from './tipusTransaccions-form.component';
import { TipusTransaccionsService } from './tipusTransaccions.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: TipusTransaccionsGridComponent },
            { path: 'create', component: TipusTransaccionsFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: TipusTransaccionsFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        TipusTransaccionsGridComponent,
        TipusTransaccionsFormComponent
    ],
    providers: [
        TipusTransaccionsService
    ]
} )
export class TipusTransaccionsModule {}