import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BngModule } from 'base-angular';

import { TipusVencimentsFormComponent } from './tipusVenciments-form.component';
import { TipusVencimentsService } from './tipusVenciments.service';

@NgModule( {
    imports: [
        CommonModule,
		BngModule
    ],
    declarations: [
        TipusVencimentsFormComponent
    ],
	entryComponents: [
		TipusVencimentsFormComponent
	],
	exports: [
		TipusVencimentsFormComponent
	],
    providers: [
        TipusVencimentsService
    ]
} )
export class TipusVencimentsFormModule {}