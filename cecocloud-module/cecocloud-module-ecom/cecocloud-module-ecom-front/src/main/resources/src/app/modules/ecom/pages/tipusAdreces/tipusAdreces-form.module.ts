import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BngModule } from 'base-angular';

import { TipusAdrecesFormComponent } from './tipusAdreces-form.component';
import { TipusAdrecesService } from './tipusAdreces.service';

@NgModule( {
    imports: [
        CommonModule,
		BngModule
    ],
    declarations: [
        TipusAdrecesFormComponent
    ],
	entryComponents: [
		TipusAdrecesFormComponent
	],
	exports: [
		TipusAdrecesFormComponent
	],
    providers: [
        TipusAdrecesService
    ]
} )
export class TipusAdrecesFormModule {}