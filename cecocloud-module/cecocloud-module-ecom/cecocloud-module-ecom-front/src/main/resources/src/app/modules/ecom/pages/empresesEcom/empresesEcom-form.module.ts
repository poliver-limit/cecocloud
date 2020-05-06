import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BngModule } from 'base-angular';

import { EmpresesEcomFormComponent } from './empresesEcom-form.component';
import { EmpresesEcomService } from './empresesEcom.service';

@NgModule( {
    imports: [
        CommonModule,
		BngModule
    ],
    declarations: [
        EmpresesEcomFormComponent
    ],
	entryComponents: [
		EmpresesEcomFormComponent
	],
	exports: [
		EmpresesEcomFormComponent
	],
    providers: [
        EmpresesEcomService
    ]
} )
export class EmpresesEcomFormModule {}