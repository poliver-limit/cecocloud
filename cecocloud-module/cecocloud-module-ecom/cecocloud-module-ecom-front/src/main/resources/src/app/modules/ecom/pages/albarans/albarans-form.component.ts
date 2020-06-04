import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormConfig, BngFormBaseComponent } from 'base-angular';
import { BngDatagridConfig } from 'base-angular';

import { AlbaransService } from './albarans.service';

// Per a generar manteniments de tipus 1
import { AlbaransLiniaService } from '../albaransLinia/albaransLinia.service';

@Component( {
	templateUrl: 'albarans-form.html'
//    template: `
//    <bng-form
//        bng-form-mant
//        [config]="formConfig"
//        [restapiService]="albaransService"></bng-form>
//`
} )
export class AlbaransFormComponent extends BngFormBaseComponent {

	public modificant: boolean = false;
	
	gridsEditables: boolean = true;
	
    formConfig: BngFormConfig = {
    }

	datagridConfig = {	
        columnFiltersEnabled: false
    };

	albaransLiniaDatagridConfig: BngDatagridConfig = {
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
			field: 'iva'
		}, {
			field: 'preuAmbIva'		
		}, {
			field: 'factorConversioSortides'	
		}]
	};    
	
	//	 Aconseguim que només es llistin linies d''albarà de l'albarà que estem editant	
	showAlbaraLiniaGrid : boolean = false;
	albara: any;
	onResourceLoad(albara: any) {		
		this.albara = albara;				
		this.albaransLiniaDatagridConfig.fixedFilter = 'albara.numero==' + this.albara.numero;		
		this.showAlbaraLiniaGrid = true;				
	}
	
	constructor(
		activatedRoute: ActivatedRoute,
		public albaransService: AlbaransService,       
		public albaransLiniaService: AlbaransLiniaService
	) {
		super(activatedRoute);
		
		activatedRoute.params.subscribe((params) => {
			if (params.id) {
				this.modificant = true;
				this.albaransLiniaDatagridConfig.fixedRowData = {
					albara: {
						id: params.id,
						description: undefined
					}
				};
			}
		});
				
	}

}