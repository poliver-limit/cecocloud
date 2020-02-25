import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormBaseComponent, BngFormConfig, BngDatagridConfig } from 'base-angular';

import { ClientsService } from './clients.service';
import { DepartamentsClientService } from '../departamentsClient/departamentsClient.service';
import { TipusClientsService } from '../tipusClients/tipusClients.service';
import { ComptesCorrentsEmpresaService } from '../comptesCorrentsEmpresa/comptesCorrentsEmpresa.service';
import { ComptesComptablesEmpresaService } from '../comptesComptablesEmpresa/comptesComptablesEmpresa.service';
import { AplicadorsClientService } from '../aplicadorsClient/aplicadorsClient.service';
import { SubClientsService } from '../subClients/subClients.service';
import { ClientsAdresaService } from '../clientsAdresa/clientsAdresa.service';
import { MatTabChangeEvent } from '@angular/material/tabs';

import { DivisesFormComponent } from '../divises/divises-form.component';
import { TipusVencimentsFormComponent } from '../tipusVenciments/tipusVenciments-form.component';
import { RegimsIvaFormComponent } from '../regimsIva/regimsIva-form.component';
import { RappelsFormComponent } from '../rappels/rappels-form.component';
import { DocumentsPagamentCobramentFormComponent } from '../documentsPagamentCobrament/documentsPagamentCobrament-form.component';
import { TipusFacturacionsFormComponent } from '../tipusFacturacions/tipusFacturacions-form.component';
import { FamiliesClientFormComponent } from '../familiesClient/familiesClient-form.component';
import { CodisPostalFormComponent } from '../codisPostal/codisPostal-form.component';
import { IdiomesFormComponent } from '../idiomes/idiomes-form.component';
import { ZonesFormComponent } from '../zones/zones-form.component';
import { EmpresesFactFormComponent } from '../empresesFact/empresesFact-form.component';
import { SeriesVendaFormComponent } from '../seriesVenda/seriesVenda-form.component';
import { IvesFormComponent } from '../ives/ives-form.component';
import { TarifesFormComponent } from '../tarifes/tarifes-form.component';
import { BancsFormComponent } from '../bancs/bancs-form.component';
import { OficinesBancariesFormComponent } from '../oficinesBancaries/oficinesBancaries-form.component';
import { TransportistesFormComponent } from '../transportistes/transportistes-form.component';
//import { OperarisFormComponent } from '../operaris/operaris-form.component';
import { ClassesRetencionsFormComponent } from '../classesRetencions/classesRetencions-form.component';
import { ClientsAdresaFormComponent } from '../clientsAdresa/clientsAdresa-form.component';
import { OrganitzacionsFormComponent } from '../organitzacions/organitzacions-form.component';
import { TarifesDescompteFormComponent } from '../tarifesDescompte/tarifesDescompte-form.component';

@Component( {
	templateUrl: 'clients-form.html'
} )


export class ClientsFormComponent extends BngFormBaseComponent {

	public modificant: boolean = false;
	
	client: any;
	
	public contactesSelected: boolean = false;	
	public tipusClientsSelected: boolean = false;
	public comptabilitatSelected: boolean = false;
	public aplicadorsClientSelected: boolean = false;
	public subClientsSelected: boolean = false;
	public adrecesComercialsSelected: boolean = false;
	
	onLinkClick(event: MatTabChangeEvent) {
		if (event.index==1) this.contactesSelected = true;		
		if (event.index==3) this.tipusClientsSelected = true;
		if (event.index==4) this.comptabilitatSelected = true;
		if (event.index==8) this.aplicadorsClientSelected = true;
		if (event.index==10) this.subClientsSelected = true;
		if (event.index==11) this.adrecesComercialsSelected = true;
	}	
	
	onResourceLoad(client: any) {
		this.client = client;
		this.departamentsClientDatagridConfig.fixedFilter = 'client.codi==' + this.client.codi;
		this.tipusClientsDatagridConfig.fixedFilter = 'client.codi==' + this.client.codi;
		this.comptesCorrentsDatagridConfig.fixedFilter = 'client.codi==' + this.client.codi;	
		this.comptesComptablesDatagridConfig.fixedFilter = 'client.codi==' + this.client.codi;
		this.aplicadorsClientDatagridConfig.fixedFilter = 'client.codi==' + this.client.codi;
		this.subClientsDatagridConfig.fixedFilter = 'client.codi==' + this.client.codi;
		this.adrecesComercialsDatagridConfig.fixedFilter = 'client.codi==' + this.client.codi;
	}

	gridsEditables: boolean = true;

    formConfig: BngFormConfig = {
    }

	datagridConfig = {	
        columnFiltersEnabled: false
    };
	
	departamentsClientDatagridConfig: BngDatagridConfig = {
		mode: 'form',		
		columns: [{
			field: 'codi'
		}, {
			field: 'nom'
		}, {
			field: 'domicili'
		}, {
			field: 'telefon1'
		}, {
			field: 'activitat'
		}, {
			field: 'codiPostal'
		}]
	};    

	tipusClientsDatagridConfig: BngDatagridConfig = {        
		mode: 'form',		
		columns: [{
			field: 'tipusProveidorClient'
		}]
    };
	
	comptesCorrentsDatagridConfig: BngDatagridConfig = {        
		mode: 'form',
		columns: [{		
			field: 'empresa',
		},{
			field: 'banc',
		},{
			field: 'oficinaBancaria',
		},{
			field: 'numeroCompteCorrent',
		},{
			field: 'digitControl'			
		}]	
    };

	comptesComptablesDatagridConfig: BngDatagridConfig = {        
		mode: 'form',
		columns: [{		
			field: 'empresa'
		},{
			field: 'compteComptable'
		},{
			field: 'compteVendes'
		}]	
    };

	aplicadorsClientDatagridConfig: BngDatagridConfig = {        
		mode: 'form',
		columns: [{		
			field: 'aplicador'		
		}]	
    };

	subClientsDatagridConfig: BngDatagridConfig = {        
		mode: 'form',
		columns: [{
			field: 'codi'
		},{		
			field: 'nom'
		},{
			field: 'domicili'
		},{
			field: 'codiPostal'
		},{
			field: 'bloquejat'
		},{
			field: 'preusPerVolum'	
		},{
			field: 'tarifa1'
		},{
			field: 'tarifaDescompte'
		}]	
    };

	adrecesComercialsDatagridConfig: BngDatagridConfig = {        
		mode: 'form',
		columns: [{
			field: 'codi'
		},{		
			field: 'domicili'
		},{
			field: 'direccionExclusivaEnvio'
		},{
			field: 'domiciliDefecte'
		},{
			field: 'bloquejada'		
		}]	
    };

    constructor(	
		activatedRoute: ActivatedRoute,
        public clientsService: ClientsService,
		public departamentsClientService: DepartamentsClientService,
		public tipusClientsService: TipusClientsService,
		public comptesCorrentsEmpresaService: ComptesCorrentsEmpresaService,
		public comptesComptablesEmpresaService: ComptesComptablesEmpresaService,
		public aplicadorsClientService: AplicadorsClientService,
		public subClientsService: SubClientsService,
		public adrecesComercialsService: ClientsAdresaService
		 ) {
			super(activatedRoute);
			this.setConfigExternalFormComponents([
				{ resourceName: 'divisa', component: DivisesFormComponent },                   
				{ resourceName: 'tipusVenciment', component: TipusVencimentsFormComponent },           
				{ resourceName: 'regimIva', component: RegimsIvaFormComponent },                 
				{ resourceName: 'rappel', component: RappelsFormComponent },                   
				{ resourceName: 'documentPagamentCobrament', component: DocumentsPagamentCobramentFormComponent },
				{ resourceName: 'tipusFacturacio', component: TipusFacturacionsFormComponent },         
				{ resourceName: 'familiaClient', component: FamiliesClientFormComponent },            
				{ resourceName: 'codiPostal', component: CodisPostalFormComponent },               
				{ resourceName: 'idioma', component: IdiomesFormComponent },                   
				{ resourceName: 'zona', component: ZonesFormComponent },                     
				{ resourceName: 'empresaFact', component: EmpresesFactFormComponent },              
				{ resourceName: 'serieVenda', component: SeriesVendaFormComponent },               
				{ resourceName: 'iva', component: IvesFormComponent },                      
				{ resourceName: 'tarifa', component: TarifesFormComponent },                   
				{ resourceName: 'banc', component: BancsFormComponent },                     
				{ resourceName: 'oficinaBancaria', component: OficinesBancariesFormComponent },         
				{ resourceName: 'transportista', component: TransportistesFormComponent },            
//				{ resourceName: 'operari', component: OperarisFormComponent },                             
				{ resourceName: 'classeRetencio', component: ClassesRetencionsFormComponent },         
				{ resourceName: 'clientAdresa', component: ClientsAdresaFormComponent },             
				{ resourceName: 'organitzacio', component: OrganitzacionsFormComponent },            
				{ resourceName: 'tarifaDescompte', component: TarifesDescompteFormComponent }				
			]);
			activatedRoute.params.subscribe((params) => {				
				if (params.id) {
					this.modificant = true;
					this.departamentsClientDatagridConfig.fixedRowData = {
						client: {
							id: params.id,
							description: undefined
						}
					};
					this.tipusClientsDatagridConfig.fixedRowData = {
						client: {
							id: params.id,
							description: undefined
						}
					};
					this.comptesCorrentsDatagridConfig.fixedRowData = {
						client: {
							id: params.id,
							description: undefined
						}
					};
					this.comptesComptablesDatagridConfig.fixedRowData = {
						client: {
							id: params.id,
							description: undefined
						}
					};
					this.aplicadorsClientDatagridConfig.fixedRowData = {
						client: {
							id: params.id,
							description: undefined
						}
					};
					this.subClientsDatagridConfig.fixedRowData = {
						client: {
							id: params.id,
							description: undefined
						}
					};
					this.adrecesComercialsDatagridConfig.fixedRowData = {
						client: {
							id: params.id,
							description: undefined
						}
					};
				}
			});
		}

}