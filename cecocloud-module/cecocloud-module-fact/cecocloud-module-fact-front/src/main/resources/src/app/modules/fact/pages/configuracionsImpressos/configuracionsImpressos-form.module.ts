import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BngModule } from 'base-angular';

import { ConfiguracionsImpressosFormComponent } from './configuracionsImpressos-form.component';
import { ConfiguracionsImpressosService } from './configuracionsImpressos.service';

@NgModule( {
    imports: [
        CommonModule,
		BngModule
    ],
    declarations: [
        ConfiguracionsImpressosFormComponent
    ],
	entryComponents: [
		ConfiguracionsImpressosFormComponent
	],
	exports: [
		ConfiguracionsImpressosFormComponent
	],
    providers: [
        ConfiguracionsImpressosService
    ]
} )
export class ConfiguracionsImpressosFormModule {}