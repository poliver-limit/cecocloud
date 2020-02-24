import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormBaseComponent, BngFormConfig, BngDatagridConfig } from 'base-angular';

import { AplicadorsService } from './aplicadors.service';
import { AplicadorsClientService } from '../aplicadorsClient/aplicadorsClient.service';

import { MatTabChangeEvent } from '@angular/material';

@Component( {
	templateUrl: 'aplicadors-form.html'
} )

export class AplicadorsFormComponent extends BngFormBaseComponent {

	public modificant: boolean = false;
	
	aplicador: any;
	
	public aplicadorsClientSelected: boolean = false;
	
	onLinkClick(event: MatTabChangeEvent) {
		if (event.index==1) this.aplicadorsClientSelected = true;		
	} 

	onResourceLoad(aplicador: any) {
		this.aplicador = aplicador;		
		this.aplicadorsClientDatagridConfig.fixedFilter = 'aplicador.contracte==' + this.aplicador.contracte;		
	}
	
	gridsEditables: boolean = true;
	
 	formConfig: BngFormConfig = {
    }

	aplicadorsClientDatagridConfig: BngDatagridConfig = {        
		mode: 'form',
		columns: [{		
			field: 'client'		
		}]	
    };
	
	constructor(	
		activatedRoute: ActivatedRoute,
        public aplicadorsService: AplicadorsService,
		public aplicadorsClientService: AplicadorsClientService ) { 
			super(activatedRoute);
			activatedRoute.params.subscribe((params) => {	
				if (params.id) {
					this.modificant = true;
					this.aplicadorsClientDatagridConfig.fixedRowData = {
						aplicador: {
							id: params.id,
							description: undefined
						}
					};
				}
			})
		}

}