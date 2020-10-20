import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BngModule } from 'base-angular';

import { TallersFormComponent } from './tallers-form.component';
import { TallersService } from './tallers.service';

@NgModule( {
    imports: [
        CommonModule,
		BngModule
    ],
    declarations: [
        TallersFormComponent
    ],
	entryComponents: [
		TallersFormComponent
	],
	exports: [
		TallersFormComponent
	],
    providers: [
        TallersService
    ]
} )
export class TallersFormModule {}