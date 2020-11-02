import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BngModule } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';
import { TranslateModule } from '@ngx-translate/core';

import { PressupostosLiniaService } from '../pressupostosLinia/pressupostosLinia.service';

import { PressupostosFormComponent } from './pressupostos-form.component';
import { PressupostosService } from './pressupostos.service';

@NgModule( {
    imports: [
        CommonModule,
		BngModule,
		MaterialModule,
		TranslateModule
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
        PressupostosService,
	
		PressupostosLiniaService
    ]
} )
export class PressupostosFormModule {}