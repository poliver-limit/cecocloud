import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BngModule } from 'base-angular';

import { IvesFormComponent } from './ives-form.component';
import { IvesService } from './ives.service';

@NgModule( {
    imports: [
        CommonModule,
		BngModule
    ],
    declarations: [
        IvesFormComponent
    ],
	entryComponents: [
		IvesFormComponent
	],
	exports: [
		IvesFormComponent
	],
    providers: [
        IvesService
    ]
} )
export class IvesFormModule {}