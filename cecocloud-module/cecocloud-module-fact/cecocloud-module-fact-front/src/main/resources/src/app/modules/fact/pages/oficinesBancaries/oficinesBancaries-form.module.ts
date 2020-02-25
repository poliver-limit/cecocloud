import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BngModule } from 'base-angular';

import { OficinesBancariesFormComponent } from './oficinesBancaries-form.component';
import { OficinesBancariesService } from './oficinesBancaries.service';

@NgModule( {
    imports: [
        CommonModule,
		BngModule
    ],
    declarations: [
        OficinesBancariesFormComponent
    ],
	entryComponents: [
		OficinesBancariesFormComponent
	],
	exports: [
		OficinesBancariesFormComponent
	],
    providers: [
        OficinesBancariesService
    ]
} )
export class OficinesBancariesFormModule {}