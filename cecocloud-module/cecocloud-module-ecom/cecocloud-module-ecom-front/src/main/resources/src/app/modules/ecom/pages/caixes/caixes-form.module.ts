import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BngModule } from 'base-angular';

import { CaixesFormComponent } from './caixes-form.component';
import { CaixesService } from './caixes.service';

@NgModule( {
    imports: [
        CommonModule,
		BngModule
    ],
    declarations: [
        CaixesFormComponent
    ],
	entryComponents: [
		CaixesFormComponent
	],
	exports: [
		CaixesFormComponent
	],
    providers: [
        CaixesService
    ]
} )
export class CaixesFormModule {}