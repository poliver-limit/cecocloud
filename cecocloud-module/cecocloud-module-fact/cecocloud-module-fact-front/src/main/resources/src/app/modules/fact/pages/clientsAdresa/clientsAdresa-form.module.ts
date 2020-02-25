import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BngModule } from 'base-angular';

import { ClientsAdresaFormComponent } from './clientsAdresa-form.component';
import { ClientsAdresaService } from './clientsAdresa.service';

@NgModule( {
    imports: [
        CommonModule,
		BngModule
    ],
    declarations: [
        ClientsAdresaFormComponent
    ],
	entryComponents: [
		ClientsAdresaFormComponent
	],
	exports: [
		ClientsAdresaFormComponent
	],
    providers: [
        ClientsAdresaService
    ]
} )
export class ClientsAdresaFormModule {}