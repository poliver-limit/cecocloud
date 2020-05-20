import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BngModule } from 'base-angular';

import { RegimsIvaFormComponent } from './regimsIva-form.component';
import { RegimsIvaService } from './regimsIva.service';

@NgModule( {
    imports: [
        CommonModule,
		BngModule
    ],
    declarations: [
        RegimsIvaFormComponent
    ],
	entryComponents: [
		RegimsIvaFormComponent
	],
	exports: [
		RegimsIvaFormComponent
	],
    providers: [
        RegimsIvaService
    ]
} )
export class RegimsIvaFormModule {}