import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BngModule } from 'base-angular';

import { ProjectesTarifaProveidorFormComponent } from './projectesTarifaProveidor-form.component';
import { ProjectesTarifaProveidorService } from './projectesTarifaProveidor.service';

@NgModule( {
    imports: [
        CommonModule,
		BngModule
    ],
    declarations: [
        ProjectesTarifaProveidorFormComponent
    ],
	entryComponents: [
		ProjectesTarifaProveidorFormComponent
	],
	exports: [
		ProjectesTarifaProveidorFormComponent
	],
    providers: [
        ProjectesTarifaProveidorService
    ]
} )
export class ProjectesTarifaProveidorFormModule {}