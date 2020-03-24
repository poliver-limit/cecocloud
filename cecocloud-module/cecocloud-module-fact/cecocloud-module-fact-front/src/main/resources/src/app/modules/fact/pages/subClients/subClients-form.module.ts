import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BngModule } from 'base-angular';

import { SubClientsFormComponent } from './subClients-form.component';
import { SubClientsService } from './subClients.service';

@NgModule( {
    imports: [
        CommonModule,
		BngModule
    ],
    declarations: [
        SubClientsFormComponent
    ],
	entryComponents: [
		SubClientsFormComponent
	],
	exports: [
		SubClientsFormComponent
	],
    providers: [
        SubClientsService
    ]
} )
export class SubClientsFormModule {}