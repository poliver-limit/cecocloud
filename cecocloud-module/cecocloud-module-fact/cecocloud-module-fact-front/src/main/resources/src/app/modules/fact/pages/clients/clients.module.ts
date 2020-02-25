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

import { DivisesFormModule } from '../divises/divises-form.module'
import { TipusVencimentsFormModule } from '../tipusVenciments/tipusVenciments-form.module'
import { RegimsIvaFormModule } from '../regimsIva/regimsIva-form.module'
import { RappelsFormModule } from '../rappels/rappels-form.module'
import { DocumentsPagamentCobramentFormModule } from '../documentsPagamentCobrament/documentsPagamentCobrament-form.module'
import { TipusFacturacionsFormModule } from '../tipusFacturacions/tipusFacturacions-form.module'
import { FamiliesClientFormModule } from '../familiesClient/familiesClient-form.module'
import { CodisPostalFormModule } from '../codisPostal/codisPostal-form.module'
import { IdiomesFormModule } from '../idiomes/idiomes-form.module'
import { ZonesFormModule } from '../zones/zones-form.module'
import { EmpresesFactFormModule } from '../empresesFact/empresesFact-form.module'
import { SeriesVendaFormModule } from '../seriesVenda/seriesVenda-form.module'
import { IvesFormModule } from '../ives/ives-form.module'
import { TarifesFormModule } from '../tarifes/tarifes-form.module'
import { BancsFormModule } from '../bancs/bancs-form.module'
import { OficinesBancariesFormModule } from '../oficinesBancaries/oficinesBancaries-form.module'
import { TransportistesFormModule } from '../transportistes/transportistes-form.module'
//import { OperarisFormModule } from '../operaris/operaris-form.module'
import { ClassesRetencionsFormModule } from '../classesRetencions/classesRetencions-form.module'
import { ClientsAdresaFormModule } from '../clientsAdresa/clientsAdresa-form.module'
import { OrganitzacionsFormModule } from '../organitzacions/organitzacions-form.module'
import { TarifesDescompteFormModule } from '../tarifesDescompte/tarifesDescompte-form.module'
import { PaisosNifFormModule } from '../paisosNif/paisosNif-form.module'
import { TipusAdrecesFormModule } from '../tipusAdreces/tipusAdreces-form.module'
import { TipusComissionsFormModule } from '../tipusComissions/tipusComissions-form.module'

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
		DivisesFormModule,                   
		TipusVencimentsFormModule,           
		RegimsIvaFormModule,                 
		RappelsFormModule,                   
		DocumentsPagamentCobramentFormModule,
		TipusFacturacionsFormModule,         
		FamiliesClientFormModule,            
		CodisPostalFormModule,               
		IdiomesFormModule,                   
		ZonesFormModule,                     
		EmpresesFactFormModule,              
		SeriesVendaFormModule,               
		IvesFormModule,                      
		TarifesFormModule,                   
		BancsFormModule,                     
		OficinesBancariesFormModule,         
		TransportistesFormModule,            
		//OperarisFormModule,                
		ClassesRetencionsFormModule,         
		ClientsAdresaFormModule,             
		OrganitzacionsFormModule,            
		TarifesDescompteFormModule,
		PaisosNifFormModule,
		TipusAdrecesFormModule,
		TipusComissionsFormModule,
        RouterModule.forChild([{
			path: '',
			component: ClientsGridComponent
		}, {
			path: 'create',
			component: ClientsFormComponent,
			canDeactivate: [BngFormExitGuard]
		}, {
			path: 'update/:id',
			component: ClientsFormComponent,
			canDeactivate: [BngFormExitGuard]
		}])
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