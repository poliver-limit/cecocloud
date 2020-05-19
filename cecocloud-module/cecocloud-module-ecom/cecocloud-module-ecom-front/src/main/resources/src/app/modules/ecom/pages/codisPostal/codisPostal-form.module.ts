import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BngModule } from 'base-angular';

import { CodisPostalFormComponent } from './codisPostal-form.component';
import { CodisPostalService } from './codisPostal.service';

@NgModule( {
    imports: [
        CommonModule,
		BngModule
    ],
    declarations: [
        CodisPostalFormComponent
    ],
	entryComponents: [
		CodisPostalFormComponent
	],
	exports: [
		CodisPostalFormComponent
	],
    providers: [
        CodisPostalService
    ]
} )
export class CodisPostalFormModule {}