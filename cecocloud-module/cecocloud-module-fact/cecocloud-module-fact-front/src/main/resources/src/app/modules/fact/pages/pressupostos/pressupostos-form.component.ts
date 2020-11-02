import { ViewChild, Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngForm, BngFormConfig, BngFormBaseComponent } from 'base-angular';
import { BngDatagridConfig } from 'base-angular';
import { FormGroup } from '@angular/forms';

import { PressupostosService } from './pressupostos.service';
import { ClientsService } from '../clients/clients.service';

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

	@ViewChild(BngForm) form: BngForm;
	
	formGroup: FormGroup;
	
	client: any;
	
	public modificant: boolean = false;
	
	gridsEditables: boolean = true;
	
    formConfig: BngFormConfig = {
    }

	datagridConfig = {	
        columnFiltersEnabled: false
    };

	pressupostosLiniaDatagridConfig: BngDatagridConfig = {
		mode: 'form',		
		columns: [
		   {			
			field: 'article'
		}, {
			field: 'descripcio'
		}, {
			field: 'factorConversioSortides'
		}, {
			field: 'preu'
		}, {
			field: 'preuAmbIva'
		}, {
			field: 'unitats'
		}, {
			field: 'preuTotalLinia'
		}, {
			field: 'preuTotalLiniaAmbIva'
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
	
	onFormGroupChange(formGroup: FormGroup) {		
		
		this.formGroup = formGroup;
		
		formGroup.get('client').valueChanges.subscribe(val => {			
			if (val!=undefined) {				
				this.clientsService.whenReady().subscribe(serveiClients => {
						var clientId = val.id;
						this.clientsService.get(clientId).subscribe(client => {							
							this.client = client;
							
							var subClientField: any = this.form.getInputField('subClient');
							if (subClientField!=undefined) {			
								subClientField.setCustomFilter('client.codi=='+this.client.codi);	
							}
							
							var clientAdresaField: any = this.form.getInputField('clientAdresa');
							if (clientAdresaField!=undefined) {			
								clientAdresaField.setCustomFilter('client.codi=='+this.client.codi);	
							}
																						
						});
					});				
			} else {
				var subClientField: any = this.form.getInputField('subClient');
					if (subClientField!=undefined) {		
						subClientField.formControl.setValue(null)							
					}
					
					var clientAdresaField: any = this.form.getInputField('clientAdresa');
					if (clientAdresaField!=undefined) {			
						clientAdresaField.formControl.setValue(null)
					}
			}
		})
		
	}
	
	constructor(
		activatedRoute: ActivatedRoute,
		public pressupostosService: PressupostosService,       
		public pressupostosLiniaService: PressupostosLiniaService,
		public clientsService: ClientsService
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