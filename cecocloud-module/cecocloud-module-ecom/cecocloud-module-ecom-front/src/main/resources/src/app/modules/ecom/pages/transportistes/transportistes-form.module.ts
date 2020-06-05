import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BngModule } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';
import { TranslateModule } from '@ngx-translate/core';

import { VehiclesService } from '../vehicles/vehicles.service';

import { TransportistesFormComponent } from './transportistes-form.component';
import { TransportistesService } from './transportistes.service';

@NgModule( {
    imports: [
        CommonModule,
		BngModule,
		MaterialModule,
		TranslateModule
    ],
    declarations: [
        TransportistesFormComponent
    ],
	entryComponents: [
		TransportistesFormComponent
	],
	exports: [
		TransportistesFormComponent
	],
    providers: [
        TransportistesService,

		VehiclesService
    ]
} )
export class TransportistesFormModule {}