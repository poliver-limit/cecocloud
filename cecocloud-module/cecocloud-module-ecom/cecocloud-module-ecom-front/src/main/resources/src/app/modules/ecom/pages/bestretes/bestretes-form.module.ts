import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BngModule } from 'base-angular';

import { BestretesFormComponent } from './bestretes-form.component';
import { BestretesService } from './bestretes.service';

@NgModule( {
    imports: [
        CommonModule,
		BngModule
    ],
    declarations: [
        BestretesFormComponent
    ],
	entryComponents: [
		BestretesFormComponent
	],
	exports: [
		BestretesFormComponent
	],
    providers: [
        BestretesService
    ]
} )
export class BestretesFormModule {}