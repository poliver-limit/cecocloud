import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BngModule } from 'base-angular';

import { ParametersFormComponent } from './parameters-form.component';
import { ParametersService } from './parameters.service';

@NgModule( {
    imports: [
        CommonModule,
		BngModule
    ],
    declarations: [
        ParametersFormComponent
    ],
	entryComponents: [
		ParametersFormComponent
	],
	exports: [
		ParametersFormComponent
	],
    providers: [
        ParametersService
    ]
} )
export class ParametersFormModule {}