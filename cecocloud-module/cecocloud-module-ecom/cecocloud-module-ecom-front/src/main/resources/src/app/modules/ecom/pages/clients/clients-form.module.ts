import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BngModule } from 'base-angular';

import { ClientsFormComponent } from './clients-form.component';
import { ClientsService } from './clients.service';

@NgModule( {
    imports: [
        CommonModule,
		BngModule
    ],
    declarations: [
        ClientsFormComponent
    ],
	entryComponents: [
		ClientsFormComponent
	],
	exports: [
		ClientsFormComponent
	],
    providers: [
        ClientsService
    ]
} )
export class ClientsFormModule {}