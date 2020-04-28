import { ViewChild, Component } from "@angular/core";
import { BngForm, BngFormBaseComponent, BngFormConfig, BngFormErrorMessages, BngDatagridConfig } from "base-angular";
import { ActivatedRoute } from '@angular/router';

import { ProjectesService } from "./projectes.service";

// Manteniments de tipus 1
import { ProjectesPressupostService } from '../projectesPressupost/projectesPressupost.service';
import { ProjectesTarifaProveidorService } from '../projectesTarifaProveidor/projectesTarifaProveidor.service';
import { ProjectesAplicacioService } from '../projectesAplicacio/projectesAplicacio.service';
import { InversionsSubjectePassiuService } from '../inversionsSubjectePassiu/inversionsSubjectePassiu.service';
import { ProveidorsVencimentService } from '../proveidorsVenciment/proveidorsVenciment.service';
import { HistoricsResponsablesService } from '../historicsResponsables/historicsResponsables.service';

// Creació embeguda sobre LOV fields
import { SeriesVendaFormComponent } from '../seriesVenda/seriesVenda-form.component';
import { DivisesFormComponent } from '../divises/divises-form.component';
import { FinalFacturesFormComponent } from '../finalFactures/finalFactures-form.component';
import { ProjectesTipusFormComponent } from '../projectesTipus/projectesTipus-form.component';
import { MagatzemsFormComponent } from '../magatzems/magatzems-form.component';
import { ClientsFormComponent } from '../clients/clients-form.component';
import { ClassesRetencionsFormComponent } from '../classesRetencions/classesRetencions-form.component';
import { AreaNegocisFormComponent } from '../areaNegocis/areaNegocis-form.component';
import { SubClientsFormComponent } from '../subClients/subClients-form.component';
import { ClientsAdresaFormComponent } from '../clientsAdresa/clientsAdresa-form.component';
import { CodisPostalFormComponent } from '../codisPostal/codisPostal-form.component';
import { ZonesFormComponent } from '../zones/zones-form.component';
import { FormGroup } from '@angular/forms';
import { firstDateOlderThanSecondDate } from './first-date-older-than-second-date-validator';



@Component({
  templateUrl: 'projectes-form.html'
})


export class ProjectesFormComponent extends BngFormBaseComponent {
	
	@ViewChild(BngForm) form: BngForm;
	
  	formConfig: BngFormConfig = {};

	errorMessages: BngFormErrorMessages = {
		secondDateOlder: {
			messageKey: 'resource.projecte.error.secondDateOlder'		
		}
	}
	
	public clientValue: string;
	
	onFormGroupChange(formGroup: FormGroup) {		
		
		// Inicialitzar la data inici de la garantia amb el valor introduït en la data de fi del projecte		
		formGroup.get('dataFi').valueChanges.subscribe(val => {				
			formGroup.get('dataIniciGarantia').setValue(val);
	 	})
		
//		this.form.getInputField('client').setCustomFilter('nomComercial=ic=C*');
		formGroup.setValidators(firstDateOlderThanSecondDate('dataInici','dataFi'));			
		formGroup.valueChanges.subscribe(val => {
//			console.log(clientValue);			
		})	
//		this.form.formGroup.get('descripcio').valueChanges.subscribe(val => {
//			debugger;
////			me.form.getInputField('client').setCustomFilter('nomComercial=ic=C*');
//		})
	}
	
//	onResourceLoad(event: any) {
////		debugger;
//	}
	
//	ngOnInit() {
//		debugger;
//	}

	projecte: any;
	
	projectesPressupostDatagridConfig: BngDatagridConfig = {        
		mode: 'form'
    };

	projectesTarifaProveidorDatagridConfig: BngDatagridConfig = {        
		mode: 'form'
    };

	projectesAplicacioDatagridConfig: BngDatagridConfig = {        
		mode: 'form'
    };

	inversionsSubjectePassiuDatagridConfig: BngDatagridConfig = {        
		mode: 'form'
    };

	proveidorsVencimentDatagridConfig: BngDatagridConfig = {        
		mode: 'form'
    };

	historicsResponsablesDatagridConfig: BngDatagridConfig = {        
		mode: 'form'
    };

	onResourceLoad(projecte: any) {
		this.projecte = projecte;		
		this.projectesPressupostDatagridConfig.fixedFilter = 'projecte.codi==' + this.projecte.codi;		
		this.projectesTarifaProveidorDatagridConfig.fixedFilter = 'projecte.codi==' + this.projecte.codi;
		this.projectesAplicacioDatagridConfig.fixedFilter = 'projecte.codi==' + this.projecte.codi;
		this.inversionsSubjectePassiuDatagridConfig.fixedFilter = 'projecte.codi==' + this.projecte.codi;
		this.proveidorsVencimentDatagridConfig.fixedFilter = 'projecte.codi==' + this.projecte.codi;
		this.historicsResponsablesDatagridConfig.fixedFilter = 'projecte.codi==' + this.projecte.codi;										
	}
	
	gridsEditables: boolean = true;
	
	public modificant: boolean = false;
		
	constructor(
		activatedRoute: ActivatedRoute,
		public projectesService: ProjectesService,
		public projectesPressupostService: ProjectesPressupostService,
		public projectesTarifaProveidorService: ProjectesTarifaProveidorService,
		public projectesAplicacioService: ProjectesAplicacioService,
		public inversionsSubjectePassiuService: InversionsSubjectePassiuService,
		public proveidorsVencimentService: ProveidorsVencimentService,
		public historicsResponsablesService: HistoricsResponsablesService) {
			super(activatedRoute);			
			this.setConfigExternalFormComponents([
				{ resourceName: 'serieVenda', component: SeriesVendaFormComponent },
				{ resourceName: 'divisa', component: DivisesFormComponent },
				{ resourceName: 'finalFactura', component: FinalFacturesFormComponent },
				{ resourceName: 'projecteTipus', component: ProjectesTipusFormComponent },
				{ resourceName: 'magatzem', component: MagatzemsFormComponent },
				{ resourceName: 'client', component: ClientsFormComponent },
				{ resourceName: 'classeRetencio', component: ClassesRetencionsFormComponent },
				{ resourceName: 'areaNegoci', component: AreaNegocisFormComponent },
				{ resourceName: 'subClient', component: SubClientsFormComponent },
				{ resourceName: 'clientAdresa', component: ClientsAdresaFormComponent },
				{ resourceName: 'codiPostal', component: CodisPostalFormComponent },
				{ resourceName: 'zona', component: ZonesFormComponent }
			])
			
			activatedRoute.params.subscribe((params) => {				
				if (params.id) {
					this.modificant = true;					
					};
					this.projectesPressupostDatagridConfig.fixedRowData = {
						projecte: {
							id: params.id,
							description: undefined
						}
					};
					this.projectesTarifaProveidorDatagridConfig.fixedRowData = {
						projecte: {
							id: params.id,
							description: undefined
						}
					};
					this.projectesAplicacioDatagridConfig.fixedRowData = {
						projecte: {
							id: params.id,
							description: undefined
						}
					};					
					this.inversionsSubjectePassiuDatagridConfig.fixedRowData = {
						projecte: {
							id: params.id,
							description: undefined
						}
					};
					this.proveidorsVencimentDatagridConfig.fixedRowData = {
						projecte: {
							id: params.id,
							description: undefined
						}
					};
					this.historicsResponsablesDatagridConfig.fixedRowData = {
						projecte: {
							id: params.id,
							description: undefined
						}
					};
				})
			}
			
		}

