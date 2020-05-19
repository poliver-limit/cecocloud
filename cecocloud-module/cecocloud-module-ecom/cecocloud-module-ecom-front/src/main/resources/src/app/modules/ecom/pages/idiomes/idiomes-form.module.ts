import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BngModule } from 'base-angular';

import { IdiomesFormComponent } from './idiomes-form.component';
import { IdiomesService } from './idiomes.service';

@NgModule( {
    imports: [
        CommonModule,
		BngModule
    ],
    declarations: [
        IdiomesFormComponent
    ],
	entryComponents: [
		IdiomesFormComponent
	],
	exports: [
		IdiomesFormComponent
	],
    providers: [
        IdiomesService
    ]
} )
export class IdiomesFormModule {}