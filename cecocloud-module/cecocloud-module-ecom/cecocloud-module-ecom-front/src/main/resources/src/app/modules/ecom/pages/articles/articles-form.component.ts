import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormConfig, BngFormBaseComponent } from 'base-angular';
import { BngDatagridConfig } from 'base-angular';

import { ArticlesService } from './articles.service';

// Per a poder renderitzar formularia externs
import { IvesFormComponent } from '../ives/ives-form.component';

// Per a generar manteniments de tipus 1
import { ArticlesInformacioService } from '../articlesInformacio/articlesInformacio.service';
import { ArticlesTraduccioService } from '../articlesTraduccio/articlesTraduccio.service';
import { MagatzemsArticleService } from '../magatzemsArticle/magatzemsArticle.service';

import { IvesService } from '../ives/ives.service';

// Per poder recuperar l'empresa del modul amb l'empresa de la sessió:
import { BngAuthService } from 'base-angular';
import { EmpresesService } from '../../../../pages/empreses/empreses.service';
import { IdentificadorsService } from '../../../../pages/identificadors/identificadors.service';
import { EmpresesEcomService } from '../empresesEcom/empresesEcom.service';

import { DivisesService } from '../divises/divises.service';

import { FormGroup } from '@angular/forms';

import { HalParam } from "@lagoshny/ngx-hal-client";

@Component( {
	templateUrl: 'articles-form.html'
} )
export class ArticlesFormComponent extends BngFormBaseComponent {
	
	iva: any;
	
	
	empresaEcom: any;
	
	formGroup: FormGroup;
	
	divisa: any;	
	
	public modificant: boolean = false;
	
	gridsEditables: boolean = true;

    formConfig: BngFormConfig = {
    }

	datagridConfig = {	
        columnFiltersEnabled: false
    };

	articlesInformacioDatagridConfig: BngDatagridConfig = {
		mode: 'form',		
		columns: [ {
			field: 'referenciaSequencial',
			width: 10	
		}, {
			field: 'descripcio',
			width: 120		
		}, {
			field: 'rutaInforme',
			width: 85
		}, {
			field: 'web',
			width: 1
		}]
	};
	
	articlesTraduccioDatagridConfig: BngDatagridConfig = {
		mode: 'form',		
		columns: [ {
			field: 'idioma',
			width: 60
		}, {
			field: 'descripcio',
			width: 160
		}]
	}; 
	
	magatzemsArticleDatagridConfig: BngDatagridConfig = {
		mode: 'form',		
		columns: [ {
			field: 'magatzemCodi',
			width: 10	
		}, {
			field: 'ubicacio'
		}, {
			field: 'stockMinim'		
		}, {
			field: 'stockMaxim'	
		}, {
			field: 'unitats'					
		}]
	};   
	
	
	//	 Aconseguim que només es llistin els ArticlesFamiliaEmpresa de l'ArticleFamilia que estem editant
	showArticleInformacioGrid : boolean = false;
	showArticleTraduccioGrid : boolean = false;
	showMagatzemArticleGrid : boolean = false;
	
	article: any;	
	onResourceLoad(article: any) {		
		this.article = article;		
		this.articlesInformacioDatagridConfig.fixedFilter = 'article.codi==' + this.article.codi;
		this.showArticleInformacioGrid = true;
		this.articlesTraduccioDatagridConfig.fixedFilter = 'article.codi==' + this.article.codi;							
		this.showArticleTraduccioGrid = true;	
		this.magatzemsArticleDatagridConfig.fixedFilter = 'article.codi==' + this.article.codi;							
		this.showMagatzemArticleGrid = true;		
	}
		
	subscriptionDecimalsPreu: any;
	subscriptionDecimalsPreuIva: any;
	subscriptionIva: any;
	subscriptionPvp: any;
	subscriptionPreuAmbIva: any;	
	
	eventsActive: boolean = false;	
	
	onFormGroupChange(formGroup: FormGroup) {	
		
		this.formGroup = formGroup;
		
		if (this.eventsActive) return;
		
		this.eventsActive = true;
		this.subscriptionDecimalsPreu = formGroup.get('decimalsPreu').valueChanges.subscribe(val => {			
			if (this.eventsActive) this.unsubscribeAllEvents(formGroup);				
			var fixedPvp = formGroup.get("fixedPvp");			
			var pvp = parseFloat(fixedPvp.value).toFixed(val);
			formGroup.get("pvp").setValue(pvp);				
			if (!this.eventsActive) this.onFormGroupChange(formGroup);	
		})
		
		this.subscriptionDecimalsPreuIva = formGroup.get('decimalsPreuIva').valueChanges.subscribe(val => {			
			if (this.eventsActive) this.unsubscribeAllEvents(formGroup);
			var fixedPreuAmbIva = formGroup.get("fixedPreuAmbIva");			
			var preuAmbIva = parseFloat(fixedPreuAmbIva.value).toFixed(val);
			formGroup.get("preuAmbIva").setValue(preuAmbIva);			
			if (!this.eventsActive) this.onFormGroupChange(formGroup);	
		})		
		
		this.subscriptionIva = formGroup.get('iva').valueChanges.subscribe(val => {			
//			if (this.eventsActive) this.unsubscribeAllEvents(formGroup);
			var ivaValue = formGroup.get('iva').value;
			if (ivaValue!=null && ivaValue !=undefined) {				
				var ivaId = ivaValue.id;
				this.ivesService.get(ivaId).subscribe(iva => {		
									
					if (this.eventsActive) this.unsubscribeAllEvents(formGroup);
					
        			this.iva = iva;					
					var ivaPercentatge = this.iva.percentatgeIva;					
					formGroup.get("ivaValue").setValue(ivaPercentatge);					
					var pvp = formGroup.get("fixedPvp").value;					
					var decimalsPreuIva = formGroup.get("decimalsPreuIva").value;		
					var preuAmbIva: number = pvp+(pvp*ivaPercentatge/100);				
					formGroup.get("fixedPreuAmbIva").setValue(preuAmbIva);					
					var preuAmbIvaDecimals = preuAmbIva.toFixed(decimalsPreuIva);					
					formGroup.get("preuAmbIva").setValue(preuAmbIvaDecimals);					
					if (!this.eventsActive) this.onFormGroupChange(formGroup);					
				})
//				if (!this.eventsActive) this.onFormGroupChange(formGroup);				
			}			
//			if (!this.eventsActive) this.onFormGroupChange(formGroup);			
		})
		
		this.subscriptionPvp = formGroup.get('pvp').valueChanges.subscribe(valor => {					
			var val : number = parseFloat(valor);
			if (this.eventsActive) this.unsubscribeAllEvents(formGroup);			
			var ivaValue = formGroup.get("ivaValue").value;			
			if (ivaValue==undefined) ivaValue = 0;		
			var decimalsPreuIva: number = parseInt(formGroup.get("decimalsPreuIva").value);				
			var preuAmbIva: number = val+(val*ivaValue/100);					
			formGroup.get("fixedPreuAmbIva").setValue(preuAmbIva);
			var preuAmbIvaDecimals = preuAmbIva.toFixed(decimalsPreuIva);
			formGroup.get("preuAmbIva").setValue(preuAmbIvaDecimals);			
			formGroup.get("fixedPvp").setValue(val);
			var decimalsPreu = formGroup.get("decimalsPreu").value;
			var pvp = val.toFixed(decimalsPreu);						
			formGroup.get("pvp").setValue(pvp);								
			if (!this.eventsActive) this.onFormGroupChange(formGroup);			
		})
		
		this.subscriptionPreuAmbIva = formGroup.get('preuAmbIva').valueChanges.subscribe(valor => {			
			var val : number = parseFloat(valor);
			if (this.eventsActive) this.unsubscribeAllEvents(formGroup);			
			var ivaValue = formGroup.get("ivaValue").value;	
			if (ivaValue==undefined) ivaValue = 0;		
			var decimalsPreu: number = parseInt(formGroup.get("decimalsPreu").value);
//			var	preuSenseIva: number = val-(val*ivaValue/100);
			var preuSenseIva: number = (val*100)/(ivaValue+100);
			formGroup.get("fixedPvp").setValue(preuSenseIva);
			var preuSenseIvaDecimals = preuSenseIva.toFixed(decimalsPreu);
			formGroup.get("pvp").setValue(preuSenseIvaDecimals);			
			formGroup.get("fixedPreuAmbIva").setValue(val);
			var decimalsPreuIva = formGroup.get("decimalsPreuIva").value;
			var preuAmbIva = val.toFixed(decimalsPreuIva);			
			formGroup.get("preuAmbIva").setValue(preuAmbIva);						
			if (!this.eventsActive) this.onFormGroupChange(formGroup);	
		})	
		
	}
	
	unsubscribeAllEvents(formGroup: FormGroup) {
		this.subscriptionDecimalsPreu.unsubscribe();
		this.subscriptionDecimalsPreuIva.unsubscribe();
		this.subscriptionIva.unsubscribe();
		this.subscriptionPvp.unsubscribe();
		this.subscriptionPreuAmbIva.unsubscribe();
		this.eventsActive = false;					
	}

    constructor(
		activatedRoute: ActivatedRoute,
        public articlesService: ArticlesService,
		public articlesInformacioService: ArticlesInformacioService,
		public articlesTraduccioService: ArticlesTraduccioService,
		public magatzemsArticleService: MagatzemsArticleService,
		public ivesService: IvesService,
		public bngAuthService: BngAuthService,
		public empresesService: EmpresesService,
		public identificadorsService: IdentificadorsService,
		public empresesEcomService: EmpresesEcomService,
		public divisesService: DivisesService) {
			
		super(activatedRoute);
		activatedRoute.params.subscribe((params) => {
			if (params.id) {
				this.modificant = true;
				
				this.articlesInformacioDatagridConfig.fixedRowData = {
					article: {
						id: params.id,
						description: undefined
					}
				};		
				
				this.articlesTraduccioDatagridConfig.fixedRowData = {
					article: {
						id: params.id,
						description: undefined
					}
				};	
				
				this.magatzemsArticleDatagridConfig.fixedRowData = {
					article: {
						id: params.id,
						description: undefined
					}
				};			
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
								
								this.empresesEcomService.whenReady().subscribe(serveiEcomEmpreses => {
									const requestEmpresaEcomParams: HalParam[] = [];
									debugger;
				 					requestEmpresaEcomParams.push({
				 						key: "query",
				 						value: "codi=='"+empresaCodi+"';identificador.codi=='"+identificadorCodi+"'"
				 					});
									this.empresesEcomService.getAll({ params: requestEmpresaEcomParams }).subscribe(empresesEcom => {
										
										this.empresaEcom = empresesEcom[0];
										this.divisesService.whenReady().subscribe(serveiDivises => {
											var divisaId = this.empresaEcom.divisa.id;
											divisesService.get(divisaId).subscribe(divisa => {
												this.divisa = divisa;												
												this.formGroup.get("decimalsPreu").setValue(this.divisa.decimalsPreus);
												this.formGroup.get("decimalsPreuIva").setValue(this.divisa.decimalsImports);
											});
										});										
									});
								});							
							});				
						});					
					});					
				});				
			}
		});		
	
		this.setConfigExternalFormComponents([
			{ resourceName: 'iva', component: IvesFormComponent }		
		]);
	}

}