import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BngModule } from 'base-angular';

import { ZonesFormComponent } from './zones-form.component';
import { ZonesService } from './zones.service';

@NgModule( {
    imports: [
        CommonModule,
		BngModule
    ],
    declarations: [
        ZonesFormComponent
    ],
	entryComponents: [
		ZonesFormComponent
	],
	exports: [
		ZonesFormComponent
	],
    providers: [
        ZonesService
    ]
} )
export class ZonesFormModule {}