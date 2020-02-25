import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BngModule } from 'base-angular';

import { TarifesFormComponent } from './tarifes-form.component';
import { TarifesService } from './tarifes.service';

@NgModule( {
    imports: [
        CommonModule,
		BngModule
    ],
    declarations: [
        TarifesFormComponent
    ],
	entryComponents: [
		TarifesFormComponent
	],
	exports: [
		TarifesFormComponent
	],
    providers: [
        TarifesService
    ]
} )
export class TarifesFormModule {}