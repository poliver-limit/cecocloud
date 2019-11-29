import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../shared/material.module';

import { TipusIncidenciesFacturaGridComponent } from './tipusIncidenciesFactura-grid.component';
import { TipusIncidenciesFacturaFormComponent } from './tipusIncidenciesFactura-form.component';
import { TipusIncidenciesFacturaService } from './tipusIncidenciesFactura.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: TipusIncidenciesFacturaGridComponent },
            { path: 'create', component: TipusIncidenciesFacturaFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: TipusIncidenciesFacturaFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        TipusIncidenciesFacturaGridComponent,
        TipusIncidenciesFacturaFormComponent
    ],
    providers: [
        TipusIncidenciesFacturaService
    ]
} )
export class TipusIncidenciesFacturaModule {}