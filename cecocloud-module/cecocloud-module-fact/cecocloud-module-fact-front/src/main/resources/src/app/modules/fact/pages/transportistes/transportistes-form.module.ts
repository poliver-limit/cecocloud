import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BngModule } from 'base-angular';

import { TransportistesFormComponent } from './transportistes-form.component';
import { TransportistesService } from './transportistes.service';

@NgModule( {
    imports: [
        CommonModule,
		BngModule
    ],
    declarations: [
        TransportistesFormComponent
    ],
	entryComponents: [
		TransportistesFormComponent
	],
	exports: [
		TransportistesFormComponent
	],
    providers: [
        TransportistesService
    ]
} )
export class TransportistesFormModule {}