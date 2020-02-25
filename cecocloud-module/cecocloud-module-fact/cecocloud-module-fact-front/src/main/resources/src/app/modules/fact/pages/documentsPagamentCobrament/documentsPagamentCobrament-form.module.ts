import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BngModule } from 'base-angular';

import { DocumentsPagamentCobramentFormComponent } from './documentsPagamentCobrament-form.component';
import { DocumentsPagamentCobramentService } from './documentsPagamentCobrament.service';

@NgModule( {
    imports: [
        CommonModule,
		BngModule
    ],
    declarations: [
        DocumentsPagamentCobramentFormComponent
    ],
	entryComponents: [
		DocumentsPagamentCobramentFormComponent
	],
	exports: [
		DocumentsPagamentCobramentFormComponent
	],
    providers: [
        DocumentsPagamentCobramentService
    ]
} )
export class DocumentsPagamentCobramentFormModule {}