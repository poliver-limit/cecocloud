import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BngModule } from 'base-angular';

import { PuntsVendaFormComponent } from './puntsVenda-form.component';
import { PuntsVendaService } from './puntsVenda.service';

@NgModule( {
    imports: [
        CommonModule,
		BngModule
    ],
    declarations: [
        PuntsVendaFormComponent
    ],
	entryComponents: [
		PuntsVendaFormComponent
	],
	exports: [
		PuntsVendaFormComponent
	],
    providers: [
        PuntsVendaService
    ]
} )
export class PuntsVendaFormModule {}