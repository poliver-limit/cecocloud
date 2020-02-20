import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { ClientsGridComponent } from './clients-grid.component';
import { ClientsFormComponent } from './clients-form.component';

import { ClientsService } from './clients.service';
import { DepartamentsClientService } from '../departamentsClient/departamentsClient.service';
import { TipusClientsService } from '../tipusClients/tipusClients.service';
import { ComptesCorrentsEmpresaService } from '../comptesCorrentsEmpresa/comptesCorrentsEmpresa.service';
import { ComptesComptablesEmpresaService } from '../comptesComptablesEmpresa/comptesComptablesEmpresa.service';
import { AplicadorsClientService } from '../aplicadorsClient/aplicadorsClient.service';
import { SubClientsService } from '../subClients/subClients.service';
import { ClientsAdresaService } from '../clientsAdresa/clientsAdresa.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: ClientsGridComponent },            
			{ path: 'create', component: ClientsFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: ClientsFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        ClientsGridComponent,	
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
		ClientsAdresaService,
		DepartamentsClientService		
    ]
} )

export class ClientsModule {}