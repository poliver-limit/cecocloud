import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BngModule } from 'base-angular';

import { BancsFormComponent } from './bancs-form.component';
import { BancsService } from './bancs.service';

@NgModule( {
    imports: [
        CommonModule,
		BngModule
    ],
    declarations: [
        BancsFormComponent
    ],
	entryComponents: [
		BancsFormComponent
	],
	exports: [
		BancsFormComponent
	],
    providers: [
        BancsService
    ]
} )
export class BancsFormModule {}