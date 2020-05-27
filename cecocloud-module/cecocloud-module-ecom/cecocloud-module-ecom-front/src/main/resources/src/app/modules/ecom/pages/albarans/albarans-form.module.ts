import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BngModule } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';
import { TranslateModule } from '@ngx-translate/core';

import { AlbaransLiniaService } from '../albaransLinia/albaransLinia.service';

import { AlbaransFormComponent } from './albarans-form.component';
import { AlbaransService } from './albarans.service';

@NgModule( {
    imports: [
        CommonModule,
		BngModule,
		MaterialModule,
		TranslateModule
    ],
    declarations: [
        AlbaransFormComponent
    ],
	entryComponents: [
		AlbaransFormComponent
	],
	exports: [
		AlbaransFormComponent
	],
    providers: [
        AlbaransService,
	
		AlbaransLiniaService
    ]
} )
export class AlbaransFormModule {}