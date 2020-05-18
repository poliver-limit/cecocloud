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
		columns: [{
			field: 'numero'
		}, {
			field: 'unitats'
		}, {
			field: 'descripcio'
		}, {
			field: 'preu'
		}, {
			field: 'factorConversioSortides'
		}, {
			field: 'preuAmbIva'
		}, {
			field: 'article'
		}]
	};    
	
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