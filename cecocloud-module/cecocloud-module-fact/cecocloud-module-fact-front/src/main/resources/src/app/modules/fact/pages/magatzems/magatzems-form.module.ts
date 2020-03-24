import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BngModule } from 'base-angular';

import { MagatzemsFormComponent } from './magatzems-form.component';
import { MagatzemsService } from './magatzems.service';

@NgModule( {
    imports: [
        CommonModule,
		BngModule
    ],
    declarations: [
        MagatzemsFormComponent
    ],
	entryComponents: [
		MagatzemsFormComponent
	],
	exports: [
		MagatzemsFormComponent
	],
    providers: [
        MagatzemsService
    ]
} )
export class MagatzemsFormModule {}