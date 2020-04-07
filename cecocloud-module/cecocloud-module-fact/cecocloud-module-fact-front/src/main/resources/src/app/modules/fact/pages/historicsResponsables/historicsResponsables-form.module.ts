import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BngModule } from 'base-angular';

import { HistoricsResponsablesFormComponent } from './historicsResponsables-form.component';
import { HistoricsResponsablesService } from './historicsResponsables.service';

@NgModule( {
    imports: [
        CommonModule,
		BngModule
    ],
    declarations: [
        HistoricsResponsablesFormComponent
    ],
	entryComponents: [
		HistoricsResponsablesFormComponent
	],
	exports: [
		HistoricsResponsablesFormComponent
	],
    providers: [
        HistoricsResponsablesService
    ]
} )
export class HistoricsResponsablesFormModule {}