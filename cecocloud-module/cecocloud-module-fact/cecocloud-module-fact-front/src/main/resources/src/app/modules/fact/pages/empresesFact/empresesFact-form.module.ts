import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BngModule } from 'base-angular';

import { EmpresesFactFormComponent } from './empresesFact-form.component';
import { EmpresesFactService } from './empresesFact.service';

@NgModule( {
    imports: [
        CommonModule,
		BngModule
    ],
    declarations: [
        EmpresesFactFormComponent
    ],
	entryComponents: [
		EmpresesFactFormComponent
	],
	exports: [
		EmpresesFactFormComponent
	],
    providers: [
        EmpresesFactService
    ]
} )
export class EmpresesFactFormModule {}