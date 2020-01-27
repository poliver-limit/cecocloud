import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { SeriesIntracomunitariaGridComponent } from './seriesIntracomunitaria-grid.component';
import { SeriesIntracomunitariaFormComponent } from './seriesIntracomunitaria-form.component';
import { SeriesIntracomunitariaService } from './seriesIntracomunitaria.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: SeriesIntracomunitariaGridComponent },
            { path: 'create', component: SeriesIntracomunitariaFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: SeriesIntracomunitariaFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        SeriesIntracomunitariaGridComponent,
        SeriesIntracomunitariaFormComponent
    ],
    providers: [
        SeriesIntracomunitariaService
    ]
} )
export class SeriesIntracomunitariaModule {}