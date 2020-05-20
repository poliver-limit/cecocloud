import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BngModule } from 'base-angular';

import { PressupostosLiniaFormComponent } from './pressupostosLinia-form.component';
import { PressupostosLiniaService } from './pressupostosLinia.service';

@NgModule( {
    imports: [
        CommonModule,
		BngModule
    ],
    declarations: [
        PressupostosLiniaFormComponent
    ],
	entryComponents: [
		PressupostosLiniaFormComponent
	],
	exports: [
		PressupostosLiniaFormComponent
	],
    providers: [
        PressupostosLiniaService
    ]
} )
export class PressupostosLiniaFormModule {}