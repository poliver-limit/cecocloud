import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BngModule } from 'base-angular';

import { TipusComissionsFormComponent } from './tipusComissions-form.component';
import { TipusComissionsService } from './tipusComissions.service';

@NgModule( {
    imports: [
        CommonModule,
		BngModule
    ],
    declarations: [
        TipusComissionsFormComponent
    ],
	entryComponents: [
		TipusComissionsFormComponent
	],
	exports: [
		TipusComissionsFormComponent
	],
    providers: [
        TipusComissionsService
    ]
} )
export class TipusComissionsFormModule {}