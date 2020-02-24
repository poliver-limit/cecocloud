import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

//import { FormControl } from '@angular/forms';

import { CercadorClientsService } from './cercadorClients.service';

@Component( {
	templateUrl: 'cercadorClients-search.html'
} )

export class CercadorClientsSearchComponent {

//	onResourceLoad(client: any) {
//		this.client = client;
//		this.client.codi = '';
//		this.client.familiaClient = '';
//		this.client.nomComercial = '';
//		this.client.nomFiscal = '';
//		this.client.nif = '';
//		this.client.organitzacio = '';
//		this.client.alias = '';
//		this.client.codiPostal = '';
//		this.client.operari = '';
//		this.client.zona = '';
//		this.client.telefon = '';
//		this.client.iva = '';
//		this.client.regimIva = '';
//		this.client.claseRetencio = '';
//		this.client.tipusVenciment = '';
//		this.client.documentPagament = '';
//	}
	
	cleanFilters(event: any) {
		
	}
	
	toFilter () {
		
	}

	extraFiltersHide = true;
	
	public extraFiltersShowHide() {		
		if (this.extraFiltersHide) {
			console.log ("mostrant");
			this.extraFiltersHide = false;
		}
		else {
			console.log ("ocultant");
			this.extraFiltersHide = true;
		}		
	}
	
    formConfig: BngFormConfig = {
    }

 	datagridConfig = {    
        columnFiltersEnabled: false
    };

    constructor(
        public cercadorClientsService: CercadorClientsService ) { }

}