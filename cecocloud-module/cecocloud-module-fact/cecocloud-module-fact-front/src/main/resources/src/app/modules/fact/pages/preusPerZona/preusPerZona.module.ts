import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { PreusPerZonaGridComponent } from './preusPerZona-grid.component';
import { PreusPerZonaFormComponent } from './preusPerZona-form.component';
import { PreusPerZonaService } from './preusPerZona.service';
import { ZonesFormModule } from '../zones/zones-form.module';
import { TransportistesFormModule } from '../transportistes/transportistes-form.module';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
        MaterialModule,
        ZonesFormModule,
        TransportistesFormModule,
        RouterModule.forChild( [
            { path: '', component: PreusPerZonaGridComponent },
            { path: 'create', component: PreusPerZonaFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: PreusPerZonaFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        PreusPerZonaGridComponent,
        PreusPerZonaFormComponent
    ],
    providers: [
        PreusPerZonaService
    ]
} )
export class PreusPerZonaModule {}