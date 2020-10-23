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

// Per poder recuperar l'empresa del modul amb l'empresa de la sessió:
import { HalParam } from "@lagoshny/ngx-hal-client";
import { BngAuthService } from 'base-angular';
import { EmpresesService } from '../../../../pages/empreses/empreses.service';
import { IdentificadorsService } from '../../../../pages/identificadors/identificadors.service';
import { EmpresesFactService } from '../empresesFact/empresesFact.service';

import { DivisesService } from '../divises/divises.service';

@Component({
  templateUrl: 'projectes-form.html'
})


export class ProjectesFormComponent extends BngFormBaseComponent {
	
	@ViewChild(BngForm) form: BngForm;
	
	empresaFact: any;	
	divisa: any;	
	formGroup: FormGroup;
	
  	formConfig: BngFormConfig = {};

	errorMessages: BngFormErrorMessages = {
		secondDateOlder: {
			messageKey: 'resource.projecte.error.secondDateOlder'		
		}
	}
	
	public clientValue: string;
	
	public codiFormatat: string;
	
	onFormGroupChange(formGroup: FormGroup) {		
		
		this.formGroup = formGroup;
		
		// Inicialitzar la data inici de la garantia amb el valor introduït en la data de fi del projecte		
		formGroup.get('dataFi').valueChanges.subscribe(val => {				
			formGroup.get('dataIniciGarantia').setValue(val);
	 	})	
	
		formGroup.get('mesosGarantia').valueChanges.subscribe(val => {			
			var campDataIniciGarantia = formGroup.get('dataIniciGarantia');
			if (campDataIniciGarantia!=undefined) {
				var mesos = val;
				var dataIniciGarantia = new Date (campDataIniciGarantia.value);
				dataIniciGarantia.setMonth(dataIniciGarantia.getMonth() + mesos%12);
				var anys = Math.trunc(mesos/12);				
				dataIniciGarantia.setFullYear(dataIniciGarantia.getFullYear()+anys);
				var dataFinalGarantiaSt = dataIniciGarantia.getFullYear() + "/" + (dataIniciGarantia.getMonth()+1) + "/" + dataIniciGarantia.getDate();
				var dataFinalGarantia = new Date(dataFinalGarantiaSt);
				formGroup.get('dataFinalGarantia').setValue(dataFinalGarantia);
			}	
		})
		
		formGroup.get('dataIniciGarantia').valueChanges.subscribe(val => {			
			var campMesos = formGroup.get('mesosGarantia');
			if (campMesos!=undefined) {
				var mesos = campMesos.value;
				var dataIniciGarantia = new Date (val);
				dataIniciGarantia.setMonth(dataIniciGarantia.getMonth() + mesos%12);
				var anys = Math.trunc(mesos/12);				
				dataIniciGarantia.setFullYear(dataIniciGarantia.getFullYear()+anys);
				var dataFinalGarantiaSt = dataIniciGarantia.getFullYear() + "/" + (dataIniciGarantia.getMonth()+1) + "/" + dataIniciGarantia.getDate();
				var dataFinalGarantia = new Date(dataFinalGarantiaSt);
				formGroup.get('dataFinalGarantia').setValue(dataFinalGarantia);
			}	
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
		formGroup.get('client').valueChanges.subscribe(val => {	
			debugger;		
//			this.form.getInputField('subClient').setCustomFilter('client.codi==1');
		})
	}
	
//	onResourceLoad(event: any) {
////		debugger;
//	}
	
//	ngOnInit() {
//		debugger;
//	}
	
	onSubclientClick(event: any) {
		debugger;
	}
	
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
		public historicsResponsablesService: HistoricsResponsablesService,
		public bngAuthService: BngAuthService,
		public empresesService: EmpresesService,
		public identificadorsService: IdentificadorsService,
		public empresesFactService: EmpresesFactService,
		public divisesService: DivisesService) {
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
				} else {
					var session = this.bngAuthService.getSession();
					var empresaId = session.e;
					var identificadorId = session.i;
					this.empresesService.whenReady().subscribe(serveiEmpreses => {						
						const requestEmpresaParams: HalParam[] = [];
	 					requestEmpresaParams.push({
	 						key: "query",
	 						value: "id=='"+empresaId+"'"
	 					});
						this.empresesService.getAll({ params: requestEmpresaParams }).subscribe(empreses => {							
							this.identificadorsService.whenReady().subscribe(serveiIdentificadors => {								
								const requestIdentificadorParams: HalParam[] = [];
 								requestIdentificadorParams.push({
 									key: "query",
 									value: "id=='"+identificadorId+"'"
 								});
								this.identificadorsService.getAll({ params: requestIdentificadorParams }).subscribe(identificadors => {									
									var empresaSessio : any;
									var identificadorSessio : any;
									empresaSessio = empreses[0];								
									identificadorSessio = identificadors[0];
									var empresaCodi = empresaSessio.codi;
									var identificadorCodi = identificadorSessio.codi;
								
									this.empresesFactService.whenReady().subscribe(serveiFactEmpreses => {										
										const requestEmpresaFactParams: HalParam[] = [];
										requestEmpresaFactParams.push({
				 							key: "query",
				 							value: "codi=='"+empresaCodi+"';identificador.codi=='"+identificadorCodi+"'"
				 						});
										this.empresesFactService.getAll({ params: requestEmpresaFactParams }).subscribe(empresesFact => {											
											this.empresaFact = empresesFact[0];
											this.divisesService.whenReady().subscribe(serveiDivises => {
												var divisaId = this.empresaFact.divisa.id;
												divisesService.get(divisaId).subscribe(divisa => {	
													this.divisa = divisa;												
													var pk = { codi: this.divisa.codi, identificadorCodi : this.divisa.identificador.id};
													var value = { description: this.divisa.nom, id: this.divisa.id, pk: pk};
													this.formGroup.get("divisa").setValue(value);													
												});
											});										
										});
									});							
								});
							});						
						})
					})
				}
				
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

