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

import { ClientsService } from '../clients/clients.service';
import { SubClientsService } from '../subClients/subClients.service';
import { CodisPostalService } from '../codisPostal/codisPostal.service';

import { preumigfacturacioNotEmptyValidator } from './preumigfacturacio-not-empty-validator';
import { nomNotEmptyValidator } from './nom-not-empty-validator';

import { ExpedientsFormComponent } from '../expedients/expedients-form.component';


@Component({
  templateUrl: 'projectes-form.html'
})


export class ProjectesFormComponent extends BngFormBaseComponent {
	
	@ViewChild(BngForm) form: BngForm;
	
	empresaFact: any;	
	divisa: any;
	client: any;	
	codiPostal: any;
	
	resource: any; // Per evitar el bug "unknown"
		
	formGroup: FormGroup;
	
  	formConfig: BngFormConfig = {};

	errorMessages: BngFormErrorMessages = {
		secondDateOlder: {
			messageKey: 'resource.projecte.error.secondDateOlder'		
		},
		preumigfacturacioNotEmpty: {
			messageKey: 'resource.projecte.error.preumigfacturacioNotEmpty'
		},
		nomNotEmpty: {
			messageKey: 'resource.projecte.error.nomNotEmpty'
		}
	}
	
	public clientValue: string;
	
	public codiFormatat: string;
	
	onFormGroupChange(formGroup: FormGroup) {		
		
		this.formGroup = formGroup;
		
		formGroup.setValidators(firstDateOlderThanSecondDate('dataInici','dataFi'));
		
		formGroup.get('horesEquiv').valueChanges.subscribe(val => {			
			formGroup.setValidators(nomNotEmptyValidator('nom','nom'));
		})
		
		formGroup.get('tipusExecucio').valueChanges.subscribe(val => {			
			formGroup.setValidators(preumigfacturacioNotEmptyValidator('tipusExecucio','preuMigFacturacio'));
		})
		
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

		formGroup.get('codiPostal').valueChanges.subscribe(val => {
			if (val!=undefined) {				
				this.codisPostalService.whenReady().subscribe(serveiCodisPostal => {
					var codiPostalId = val.id;
					this.codisPostalService.get(codiPostalId).subscribe(codiPostal => {							
						this.codiPostal = codiPostal;
						var poblacioField: any = this.form.getInputField('poblacio');
						if (poblacioField!=undefined) {			
							poblacioField.formControl.setValue(this.codiPostal.poblacio);
						}							
					})
				})
			} else {
				var poblacioField: any = this.form.getInputField('poblacio');
				if (poblacioField!=undefined) {			
					poblacioField.formControl.setValue(null);
				}	
			}
		})						
			
		formGroup.get('client').valueChanges.subscribe(val => {			
			if (val!=undefined) {				
				this.clientsService.whenReady().subscribe(serveiClients => {
						var clientId = val.id;
						this.clientsService.get(clientId).subscribe(client => {							
							this.client = client;							
							
							var subClientField: any = this.form.getInputField('subClient');													
							if (subClientField!=undefined) {	
								
								// Tall de codi per solventar bug "unknown" ///////////////////////////////////////////
								this.resource = 	subClientField.restapiLovField.restapiService.resource;
								if (this.resource == 'unknown') {						
									console.log("subClientField.restapiLovField.restapiService.resource: " + this.resource);									
									subClientField.restapiLovField.restapiService.resource = "fact/subClients";
									console.log("Interceptat i arreglat!");
								}
								// Tall de codi per solventar bug "unknown" ///////////////////////////////////////////
								
								subClientField.setCustomFilter('client.codi=='+this.client.codi);															
							}
							
							var clientAdresaField: any = this.form.getInputField('clientAdresa');
							if (clientAdresaField!=undefined) {			
								
								// Tall de codi per solventar bug "unknown" ///////////////////////////////////////////
								this.resource = clientAdresaField.restapiLovField.restapiService.resource;
								if (this.resource == 'unknown') {						
									console.log("clientAdresaField.restapiLovField.restapiService.resource: " + this.resource);									
									clientAdresaField.restapiLovField.restapiService.resource = "fact/clientsAdresa";
									console.log("Interceptat i arreglat!");
								}
								// Tall de codi per solventar bug "unknown" ///////////////////////////////////////////
													
								clientAdresaField.setCustomFilter('client.codi=='+this.client.codi);	
							}								
							
							this.projectesPressupostDatagridConfig.fixedFilter = 'projecte.codi==' + this.projecte.codi + '&client.codi==' + this.client.codi;
																								
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
		
		formGroup.get('horesEquivGarantia').valueChanges.subscribe(val => {		
			this.calcularHoresEquivalencia();
			this.calcularPercentatgeExecucio();
		});
		
		formGroup.get('horesEquivConstruccio').valueChanges.subscribe(val => {		
			this.calcularHoresEquivalencia();
			this.calcularPercentatgeExecucio();	
		});
		
		formGroup.get('percentExecucioGarantia').valueChanges.subscribe(val => {			
			this.calcularPercentatgeExecucio();
		})			
			
		formGroup.get('percentExecucioConstruccio').valueChanges.subscribe(val => {			
			this.calcularPercentatgeExecucio();
		})
		
	}
	
	calcularHoresEquivalencia(): void {
			
		var horesEquiv:number = 0;			
		var horesEquivGarantia:number = this.formGroup.get('horesEquivGarantia').value;	
		var horesEquivConstruccio:number = this.formGroup.get('horesEquivConstruccio').value;			
		if ((horesEquivGarantia!=undefined) || (horesEquivConstruccio!=undefined)) {
			if (horesEquivConstruccio==undefined) horesEquivConstruccio = 0;
			if (horesEquivGarantia==undefined) horesEquivGarantia = 0;	
			horesEquiv = Number(horesEquivConstruccio)+Number(horesEquivGarantia);				
		}			
		this.formGroup.get('horesEquiv').setValue(horesEquiv);
	}
	
	calcularPercentatgeExecucio(): void {
		
		var percentExecucioGarantia:number = this.formGroup.get('percentExecucioGarantia').value;
		var percentExecucioConstruccio:number = this.formGroup.get('percentExecucioConstruccio').value;
		var horesEquivConstruccio:number = this.formGroup.get('horesEquivConstruccio').value;
		var horesEquivGarantia:number = this.formGroup.get('horesEquivGarantia').value;
		var horesEquiv: number = this.formGroup.get('horesEquiv').value;	
		if (horesEquivConstruccio==undefined) horesEquivConstruccio = 0;
		if (horesEquivGarantia==undefined) horesEquivGarantia = 0;			
		if (percentExecucioGarantia==undefined) percentExecucioGarantia = 0;
		if (percentExecucioConstruccio==undefined) percentExecucioConstruccio = 0;
		var percentExecucioLliure:number = 0;
		
		if ((horesEquiv!=undefined)&&(horesEquiv!=0)) {
			percentExecucioLliure = (
										(
											((Number(percentExecucioConstruccio)/100)*Number(horesEquivConstruccio))+
									    	((Number(percentExecucioGarantia)/100)*Number(horesEquivGarantia))
										) /
										(
											(horesEquiv)
										)
									) * 100;
			this.formGroup.get('percentExecucioLliure').setValue(percentExecucioLliure);	
		}	
		
	}
	
	ngOnInit() {		
	}	
	
	projecte: any;
	
	projectesPressupostDatagridConfig: BngDatagridConfig = {        
		mode: 'form',		
		columns: [{
			field: 'pressupost',
			width: 150
		}, {
			field: 'capitol',
			width: 20
		}, {
			field: 'partida',
			width: 20			
		}, {
			field: 'import',
			width: 20
		}, {
			field: 'observacions',
			width: 100
		}]
    };

	projectesTarifaProveidorDatagridConfig: BngDatagridConfig = {        
		mode: 'form'
    };

	projectesAplicacioDatagridConfig: BngDatagridConfig = {        
		mode: 'form',
		columns: [{
			field: 'codi',
			width: 60
		}, {
			field: 'codiProjecteAap',
			width: 120
		}, {
			field: 'valorPercentual',
			width: 20			
		}, {
			field: 'observacions',
			width: 110
		}]
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
		public divisesService: DivisesService,
		public clientsService: ClientsService,
		public subClientsService: SubClientsService,
		public codisPostalService: CodisPostalService) {
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
				{ resourceName: 'zona', component: ZonesFormComponent },
				{ resourceName: 'expedient', component: ExpedientsFormComponent }
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

