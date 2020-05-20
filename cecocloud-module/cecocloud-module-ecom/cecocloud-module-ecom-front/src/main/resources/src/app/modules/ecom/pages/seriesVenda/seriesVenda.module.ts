import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { SeriesVendaGridComponent } from './seriesVenda-grid.component';
import { SeriesVendaFormComponent } from './seriesVenda-form.component';
import { SeriesVendaService } from './seriesVenda.service';

import { SeriesVendaFormModule } from './seriesVenda-form.module';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
		SeriesVendaFormModule,
        RouterModule.forChild( [
            { path: '', component: SeriesVendaGridComponent },
            { path: 'create', component: SeriesVendaFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: SeriesVendaFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        SeriesVendaGridComponent        
    ],
    providers: [
        SeriesVendaService
    ]
} )
export class SeriesVendaModule {}