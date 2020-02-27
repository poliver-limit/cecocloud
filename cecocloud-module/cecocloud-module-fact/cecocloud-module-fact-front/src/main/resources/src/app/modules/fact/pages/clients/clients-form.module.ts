import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BngModule } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';
import { TranslateModule } from '@ngx-translate/core';

import { DepartamentsClientService } from '../departamentsClient/departamentsClient.service';
import { TipusClientsService } from '../tipusClients/tipusClients.service';
import { ComptesCorrentsEmpresaService } from '../comptesCorrentsEmpresa/comptesCorrentsEmpresa.service';
import { ComptesComptablesEmpresaService } from '../comptesComptablesEmpresa/comptesComptablesEmpresa.service';
import { AplicadorsClientService } from '../aplicadorsClient/aplicadorsClient.service';
import { SubClientsService } from '../subClients/subClients.service';
import { ClientsAdresaService } from '../clientsAdresa/clientsAdresa.service';

import { ClientsFormComponent } from './clients-form.component';
import { ClientsService } from './clients.service';

@NgModule( {
    imports: [
        CommonModule,
		BngModule,
		MaterialModule,
		TranslateModule
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
        ClientsService,

		DepartamentsClientService,
		TipusClientsService,
		ComptesCorrentsEmpresaService,
		ComptesComptablesEmpresaService,
		AplicadorsClientService,
		SubClientsService,
		ClientsAdresaService		
    ]
} )
export class ClientsFormModule {}