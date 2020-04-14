import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BngModule } from 'base-angular';

import { PartidesFormComponent } from './partides-form.component';
import { PartidesService } from './partides.service';

@NgModule( {
    imports: [
        CommonModule,
		BngModule
    ],
    declarations: [
        PartidesFormComponent
    ],
	entryComponents: [
		PartidesFormComponent
	],
	exports: [
		PartidesFormComponent
	],
    providers: [
        PartidesService
    ]
} )
export class PartidesFormModule {}