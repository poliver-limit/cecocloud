import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BngModule } from 'base-angular';

import { TarifesProveidorFormComponent } from './tarifesProveidor-form.component';
import { TarifesProveidorService } from './tarifesProveidor.service';

@NgModule( {
    imports: [
        CommonModule,
		BngModule
    ],
    declarations: [
        TarifesProveidorFormComponent
    ],
	entryComponents: [
		TarifesProveidorFormComponent
	],
	exports: [
		TarifesProveidorFormComponent
	],
    providers: [
        TarifesProveidorService
    ]
} )
export class TarifesProveidorFormModule {}