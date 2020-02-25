import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BngModule } from 'base-angular';

import { TarifesDescompteFormComponent } from './tarifesDescompte-form.component';
import { TarifesDescompteService } from './tarifesDescompte.service';

@NgModule( {
    imports: [
        CommonModule,
		BngModule
    ],
    declarations: [
        TarifesDescompteFormComponent
    ],
	entryComponents: [
		TarifesDescompteFormComponent
	],
	exports: [
		TarifesDescompteFormComponent
	],
    providers: [
        TarifesDescompteService
    ]
} )
export class TarifesDescompteFormModule {}