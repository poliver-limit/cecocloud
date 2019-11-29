import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../shared/material.module';

import { SeriesCompraGridComponent } from './seriesCompra-grid.component';
import { SeriesCompraFormComponent } from './seriesCompra-form.component';
import { SeriesCompraService } from './seriesCompra.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: SeriesCompraGridComponent },
            { path: 'create', component: SeriesCompraFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: SeriesCompraFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        SeriesCompraGridComponent,
        SeriesCompraFormComponent
    ],
    providers: [
        SeriesCompraService
    ]
} )
export class SeriesCompraModule {}