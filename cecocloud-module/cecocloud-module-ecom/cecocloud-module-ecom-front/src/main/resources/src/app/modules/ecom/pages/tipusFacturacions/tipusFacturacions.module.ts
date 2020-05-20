import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { TipusFacturacionsGridComponent } from './tipusFacturacions-grid.component';
import { TipusFacturacionsFormComponent } from './tipusFacturacions-form.component';
import { TipusFacturacionsService } from './tipusFacturacions.service';

import { TipusFacturacionsFormModule } from './tipusFacturacions-form.module';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
		TipusFacturacionsFormModule,
        RouterModule.forChild( [
            { path: '', component: TipusFacturacionsGridComponent },
            { path: 'create', component: TipusFacturacionsFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: TipusFacturacionsFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        TipusFacturacionsGridComponent        
    ],
    providers: [
        TipusFacturacionsService
    ]
} )
export class TipusFacturacionsModule {}