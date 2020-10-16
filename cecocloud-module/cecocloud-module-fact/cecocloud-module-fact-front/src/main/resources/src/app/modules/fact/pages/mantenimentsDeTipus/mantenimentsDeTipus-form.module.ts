import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BngModule } from 'base-angular';

import { MantenimentsDeTipusFormComponent } from './mantenimentsDeTipus-form.component';
import { MantenimentsDeTipusService } from './mantenimentsDeTipus.service';

@NgModule( {
    imports: [
        CommonModule,
		BngModule
    ],
    declarations: [
        MantenimentsDeTipusFormComponent
    ],
	entryComponents: [
		MantenimentsDeTipusFormComponent
	],
	exports: [
		MantenimentsDeTipusFormComponent
	],
    providers: [
        MantenimentsDeTipusService
    ]
} )
export class MantenimentsDeTipusFormModule {}