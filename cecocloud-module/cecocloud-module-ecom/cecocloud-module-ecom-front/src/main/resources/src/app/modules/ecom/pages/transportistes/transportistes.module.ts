import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { TransportistesGridComponent } from './transportistes-grid.component';
import { TransportistesFormComponent } from './transportistes-form.component';

import { TransportistesService } from './transportistes.service';

import { TransportistesFormModule } from './transportistes-form.module';

import { VehiclesService } from '../vehicles/vehicles.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
		TransportistesFormModule,
        RouterModule.forChild( [
            { path: '', component: TransportistesGridComponent },
            { path: 'create', component: TransportistesFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: TransportistesFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        TransportistesGridComponent        
    ],
    providers: [
        TransportistesService,

		VehiclesService
    ]
} )
export class TransportistesModule {}