import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BngModule } from 'base-angular';

import { FamiliesClientFormComponent } from './familiesClient-form.component';
import { FamiliesClientService } from './familiesClient.service';

@NgModule( {
    imports: [
        CommonModule,
		BngModule
    ],
    declarations: [
        FamiliesClientFormComponent
    ],
	entryComponents: [
		FamiliesClientFormComponent
	],
	exports: [
		FamiliesClientFormComponent
	],
    providers: [
        FamiliesClientService
    ]
} )
export class FamiliesClientFormModule {}