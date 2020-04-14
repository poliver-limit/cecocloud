import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BngModule } from 'base-angular';

import { CapitolsFormComponent } from './capitols-form.component';
import { CapitolsService } from './capitols.service';

@NgModule( {
    imports: [
        CommonModule,
		BngModule
    ],
    declarations: [
        CapitolsFormComponent
    ],
	entryComponents: [
		CapitolsFormComponent
	],
	exports: [
		CapitolsFormComponent
	],
    providers: [
        CapitolsService
    ]
} )
export class CapitolsFormModule {}