import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BngModule } from 'base-angular';

import { DivisesFormComponent } from './divises-form.component';
import { DivisesService } from './divises.service';

@NgModule( {
    imports: [
        CommonModule,
		BngModule
    ],
    declarations: [
        DivisesFormComponent
    ],
	entryComponents: [
		DivisesFormComponent
	],
	exports: [
		DivisesFormComponent
	],
    providers: [
        DivisesService
    ]
} )
export class DivisesFormModule {}