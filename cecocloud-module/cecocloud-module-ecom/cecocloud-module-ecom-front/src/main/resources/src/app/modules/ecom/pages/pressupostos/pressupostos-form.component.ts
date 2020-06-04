import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormConfig, BngFormBaseComponent } from 'base-angular';
import { BngDatagridConfig } from 'base-angular';

import { PressupostosService } from './pressupostos.service';

// Per a generar manteniments de tipus 1
import { PressupostosLiniaService } from '../pressupostosLinia/pressupostosLinia.service';

@Component( {
	templateUrl: 'pressupostos-form.html'
//    template: `
//    <bng-form
//        bng-form-mant
//        [config]="formConfig"
//        [restapiService]="pressupostosService"></bng-form>
//`
} )
export class PressupostosFormComponent extends BngFormBaseComponent {

	public modificant: boolean = false;
	
	gridsEditables: boolean = true;
	
    formConfig: BngFormConfig = {
    }

	datagridConfig = {	
        columnFiltersEnabled: false
    };

	pressupostosLiniaDatagridConfig: BngDatagridConfig = {
		mode: 'form',		
		columns: [ {
			field: 'unitats'
		}, {
			field: 'article'
		}, {
			field: 'descripcio'
		}, {
			field: 'preu'
		}, {
			field: 'preuAmbIva'
		}, {
			field: 'factorConversioSortides'		
		}]
	};    
	
	//	 Aconseguim que només es llistin linies de pressupost del pressupost que estem editant	
	showPressupostLiniaGrid : boolean = false;
	pressupost: any;
	onResourceLoad(pressupost: any) {		
		this.pressupost = pressupost;				
		this.pressupostosLiniaDatagridConfig.fixedFilter = 'pressupost.codi==' + this.pressupost.codi;		
		this.showPressupostLiniaGrid = true;				
	}
	
	constructor(
		activatedRoute: ActivatedRoute,
		public pressupostosService: PressupostosService,       
		public pressupostosLiniaService: PressupostosLiniaService
	) {
		super(activatedRoute);
		
		activatedRoute.params.subscribe((params) => {
			if (params.id) {				
				this.modificant = true;
				this.pressupostosLiniaDatagridConfig.fixedRowData = {
					pressupost: {
						id: params.id,
						description: undefined
					}
				};
			}
		});
				
	}

}