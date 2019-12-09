import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../shared/material.module';

import { TransaccionsGridComponent } from './transaccions-grid.component';
import { TransaccionsFormComponent } from './transaccions-form.component';
import { TransaccionsService } from './transaccions.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: TransaccionsGridComponent },
            { path: 'create', component: TransaccionsFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: TransaccionsFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        TransaccionsGridComponent,
        TransaccionsFormComponent
    ],
    providers: [
        TransaccionsService
    ]
} )
export class TransaccionsModule {}