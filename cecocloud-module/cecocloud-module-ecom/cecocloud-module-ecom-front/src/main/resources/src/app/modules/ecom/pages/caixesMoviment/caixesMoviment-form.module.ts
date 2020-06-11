import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BngModule } from 'base-angular';

import { CaixesMovimentFormComponent } from './caixesMoviment-form.component';
import { CaixesMovimentService } from './caixesMoviment.service';

@NgModule( {
    imports: [
        CommonModule,
		BngModule
    ],
    declarations: [
        CaixesMovimentFormComponent
    ],
	entryComponents: [
		CaixesMovimentFormComponent
	],
	exports: [
		CaixesMovimentFormComponent
	],
    providers: [
        CaixesMovimentService
    ]
} )
export class CaixesMovimentFormModule {}