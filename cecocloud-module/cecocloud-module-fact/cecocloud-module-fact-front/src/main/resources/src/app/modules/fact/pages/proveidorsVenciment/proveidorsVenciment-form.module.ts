import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BngModule } from 'base-angular';

import { ProveidorsVencimentFormComponent } from './proveidorsVenciment-form.component';
import { ProveidorsVencimentService } from './proveidorsVenciment.service';

@NgModule( {
    imports: [
        CommonModule,
		BngModule
    ],
    declarations: [
        ProveidorsVencimentFormComponent
    ],
	entryComponents: [
		ProveidorsVencimentFormComponent
	],
	exports: [
		ProveidorsVencimentFormComponent
	],
    providers: [
        ProveidorsVencimentService
    ]
} )
export class ProveidorsVencimentFormModule {}