import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormConfig, BngFormBaseComponent } from 'base-angular';
import { BngDatagridConfig } from 'base-angular';

import { TransportistesService } from './transportistes.service';

// Per a generar manteniments de tipus 1
import { VehiclesService } from '../vehicles/vehicles.service';

@Component( {
   templateUrl: 'transportistes-form.html'
} )
export class TransportistesFormComponent extends BngFormBaseComponent {

	public modificant: boolean = false;
	
	gridsEditables: boolean = true;
	
    formConfig: BngFormConfig = {
    }

	datagridConfig = {	
        columnFiltersEnabled: false
    };

	vehiclesDatagridConfig: BngDatagridConfig = {
		mode: 'form',		
		columns: [ {
			field: 'codi'
		}, {
			field: 'descripcio'
		}, {
			field: 'matricula'
		}, {
			field: 'matriculaRemolc'
		}, {
			field: 'nif'
		}, {
			field: 'conductorHabitual'
		}, {
			field: 'observacions'
		}, {
			field: 'tara'
		}, {
			field: 'pesMaxim'
		}, {
			field: 'actiu'
		}, {
			field: 'vehicleEmpresa'	
		}]
	}; 
	
//	 Aconseguim que només es llistin els Vehicles del transportista que estem editant	
	showVehicleGrid : boolean = false;
	transportista: any;
	onResourceLoad(transportista: any) {		
		this.transportista = transportista;				
		this.vehiclesDatagridConfig.fixedFilter = 'transportista.codi==' + this.transportista.codi;			
		this.showVehicleGrid = true;				
	}
	
    constructor(
		activatedRoute: ActivatedRoute,
        public transportistesService: TransportistesService,
		public vehiclesService: VehiclesService
	) {
			super(activatedRoute);
			activatedRoute.params.subscribe((params) => {
			if (params.id) {
				this.modificant = true;
				
				this.vehiclesDatagridConfig.fixedRowData = {
					transportista: {
						id: params.id,
						description: undefined
					}
				};					
			}
		});
	  }
}