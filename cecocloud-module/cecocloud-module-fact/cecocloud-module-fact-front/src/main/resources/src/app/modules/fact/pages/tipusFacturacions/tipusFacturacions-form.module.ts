import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BngModule } from 'base-angular';

import { TipusFacturacionsFormComponent } from './tipusFacturacions-form.component';
import { TipusFacturacionsService } from './tipusFacturacions.service';

@NgModule( {
    imports: [
        CommonModule,
		BngModule
    ],
    declarations: [
        TipusFacturacionsFormComponent
    ],
	entryComponents: [
		TipusFacturacionsFormComponent
	],
	exports: [
		TipusFacturacionsFormComponent
	],
    providers: [
        TipusFacturacionsService
    ]
} )
export class TipusFacturacionsFormModule {}