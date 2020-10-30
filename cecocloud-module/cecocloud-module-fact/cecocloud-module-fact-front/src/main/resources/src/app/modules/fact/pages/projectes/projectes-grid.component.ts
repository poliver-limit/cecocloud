import { Component, OnInit } from '@angular/core';
import { ViewChild } from "@angular/core";
import { BngForm, BngFormConfig, BngFormBaseComponent } from 'base-angular';
import { ProjectesService } from './projectes.service';
import { FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { ClientsService } from '../clients/clients.service';
import { ProjectesTipusService } from '../projectesTipus/projectesTipus.service';

@Component( {
	templateUrl: 'projectes-grid.html'
} )
export class ProjectesGridComponent extends BngFormBaseComponent implements OnInit {

	@ViewChild('formulari') form: BngForm;
	
	client: any;
	projecteTipus: any;
	
	externalFilter: string;
	
	datagridConfig = {        
        columnFiltersEnabled: true,
		paginationEnabled: true,		
		columns: [{
				field: 'codi'
			}, {
				field: 'nom'
			}, {
				field: 'client'
			}, {
				field: 'estat'			
			}, {
				field: 'dataInici'
			}, {
				field: 'dataFi'
			}]
	};
	
	formConfig: BngFormConfig = {
		mode: 'headless',
//		readOnlyStateEnabled: false
    }

	formGroup: FormGroup;
	
	cleanFilters(event: any) {		
		this.cleanAllFilters(['codi','nom','client','projecteTipus','estat']);		
	}
	
	cleanAllFilters(filterNames: string[]) {
		filterNames.forEach (filterName => {
			var filter = this.formGroup.get(filterName).setValue(undefined);
		})
	}
	
	toFilter (event: any) {	
		if (this.externalFilter) {			
			this.externalFilter = undefined;
		}				
		this.generateSimpleFilters(['codi','nom','estat']);		
		this.generateClientFilter();
		this.generateProjecteTipusFilter();		
	}

	generateSimpleFilters (filterNames: string[]) {		
		
		filterNames.forEach (filterName => {
			var filter = this.formGroup.get(filterName).value;			
			if ((filter!=undefined)&&(filter!='')) {					
				if (this.externalFilter != undefined) {
					this.externalFilter = this.externalFilter + ";";
					this.externalFilter = this.externalFilter + filterName + "=ic=" + filter;
				} else {
					this.externalFilter = filterName + "=ic=" + filter;	
				}				
			}	
		})	
	}
	
	generateClientFilter () {
		var clientFilter = this.formGroup.get('client').value;
		if ((clientFilter!=undefined)&&(clientFilter!='')) {	
			
			this.clientsService.whenReady().subscribe(serveiClients => {
				var clientId = clientFilter.id;
				this.clientsService.get(clientId).subscribe(client => {	
					this.client = client;				
					if (this.externalFilter != undefined) {
						this.externalFilter = this.externalFilter + ";";
						this.externalFilter = this.externalFilter + "client.codi==" + this.client.codi;
					} else {
						this.externalFilter = "client.codi==" + this.client.codi;	
					}					
				});
			});						
		}		
	}
	
	generateProjecteTipusFilter () {
		var projecteTipusFilter = this.formGroup.get('projecteTipus').value;
		if ((projecteTipusFilter!=undefined)&&(projecteTipusFilter!='')) {	
			
			this.projectesTipusService.whenReady().subscribe(serveiProjectesTipus => {
				var projecteTipusId = projecteTipusFilter.id;
				this.projectesTipusService.get(projecteTipusId).subscribe(projecteTipus => {	
					this.projecteTipus = projecteTipus;				
					if (this.externalFilter != undefined) {
						this.externalFilter = this.externalFilter + ";";
						this.externalFilter = this.externalFilter + "projecteTipus.codi==" + this.projecteTipus.codi;
					} else {
						this.externalFilter = "projecteTipus.codi==" + this.projecteTipus.codi;	
					}					
				});
			});						
		}		
	}

	onCodiBlur(event: any) {		
		var codiValue: any = this.formGroup.get('codi').value;
		if (!isNaN(codiValue)) {
			if (codiValue!='') {
				var newValue = this.zfill(codiValue,6);
				this.formGroup.get('codi').setValue(newValue);
			}		
		} 	
	}
	
	zfill(number, width): string {
    	var numberOutput = Math.abs(number); /* Valor absoluto del número */
    	var length = number.toString().length; /* Largo del número */ 
    	var zero = "0"; /* String de cero */  
    
    	if (width <= length) {
        	if (number < 0) {
				return ("-" + numberOutput.toString()); 
        	} else {
            	return numberOutput.toString(); 
        	}
    	} else {
        	if (number < 0) {
            	return ("-" + (zero.repeat(width - length)) + numberOutput.toString()); 
        	} else {
            	return ((zero.repeat(width - length)) + numberOutput.toString()); 
        	}
    	}
	}
	
    ngOnInit() {		
    }

	onNomBlur (event: any) {			
		this.formGroup.get('nom').setErrors(null);		
	}
	
	onFormGroupChange(formGroup: FormGroup) {		
		this.formGroup = formGroup;				
		this.formGroup.get('nom').valueChanges.subscribe(val => {			
			this.formGroup.get('nom').setErrors(null);
		})
	}
	
	onResourceLoad(event: any) {		
		this.externalFilter = "codi==--1";
	}		
	

    constructor(
		activatedRoute: ActivatedRoute,
        public projectesService: ProjectesService,
		public clientsService: ClientsService,
		public projectesTipusService: ProjectesTipusService ) {
			super(activatedRoute);				
 		}

}