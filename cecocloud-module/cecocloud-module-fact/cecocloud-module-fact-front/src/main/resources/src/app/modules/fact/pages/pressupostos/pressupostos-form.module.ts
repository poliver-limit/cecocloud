import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BngModule } from 'base-angular';

import { PressupostosFormComponent } from './pressupostos-form.component';
import { PressupostosService } from './pressupostos.service';

@NgModule( {
    imports: [
        CommonModule,
		BngModule
    ],
    declarations: [
        PressupostosFormComponent
    ],
	entryComponents: [
		PressupostosFormComponent
	],
	exports: [
		PressupostosFormComponent
	],
    providers: [
        PressupostosService
    ]
} )
export class PressupostosFormModule {}