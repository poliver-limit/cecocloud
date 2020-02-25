import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BngModule } from 'base-angular';

import { RappelsFormComponent } from './rappels-form.component';
import { RappelsService } from './rappels.service';

@NgModule( {
    imports: [
        CommonModule,
		BngModule
    ],
    declarations: [
        RappelsFormComponent
    ],
	entryComponents: [
		RappelsFormComponent
	],
	exports: [
		RappelsFormComponent
	],
    providers: [
        RappelsService
    ]
} )
export class RappelsFormModule {}