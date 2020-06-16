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

import { FormGroup } from '@angular/forms';

//import { Subscription } from 'rxjs/Subscription';

@Component( {
	templateUrl: 'articles-form.html'
} )
export class ArticlesFormComponent extends BngFormBaseComponent {
	
	iva: any;
	
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
			if (this.eventsActive) this.unsubscribeAllEvents(formGroup);
			var ivaValue = formGroup.get('iva').value;
			if (ivaValue!=null && ivaValue !=undefined) {				
				var ivaId = ivaValue.id;
				this.ivesService.get(ivaId).subscribe(iva => {						
        			this.iva = iva;					
					var ivaPercentatge = this.iva.percentatgeIva;					
					formGroup.get("ivaValue").setValue(ivaPercentatge);					
					var pvp = formGroup.get("fixedPvp").value;					
					var decimalsPreuIva = formGroup.get("decimalsPreuIva").value;					
					var preuAmbIva = pvp*(1+(ivaPercentatge/100));					
					formGroup.get("fixedPreuAmbIva").setValue(preuAmbIva);					
					var preuAmbIvaDecimals = preuAmbIva.toFixed(decimalsPreuIva);					
					formGroup.get("preuAmbIva").setValue(preuAmbIvaDecimals);					
					if (!this.eventsActive) this.onFormGroupChange(formGroup);					
				})
				if (!this.eventsActive) this.onFormGroupChange(formGroup);				
			}			
			if (!this.eventsActive) this.onFormGroupChange(formGroup);			
		})
		
		this.subscriptionPvp = formGroup.get('pvp').valueChanges.subscribe(val => {			
			if (this.eventsActive) this.unsubscribeAllEvents(formGroup);			
			var ivaValue = formGroup.get("ivaValue").value;			
			var decimalsPreuIva = formGroup.get("decimalsPreuIva").value;			
			var preuAmbIva = val*(1+(ivaValue/100));			
			formGroup.get("fixedPreuAmbIva").setValue(preuAmbIva);
			var preuAmbIvaDecimals = preuAmbIva.toFixed(decimalsPreuIva);
			formGroup.get("preuAmbIva").setValue(preuAmbIvaDecimals);			
			formGroup.get("fixedPvp").setValue(val);
			var decimalsPreu = formGroup.get("decimalsPreu").value;
			var pvp = parseFloat(val).toFixed(decimalsPreu);			
			formGroup.get("pvp").setValue(pvp);						
			if (!this.eventsActive) this.onFormGroupChange(formGroup);
		})
		
		this.subscriptionPreuAmbIva = formGroup.get('preuAmbIva').valueChanges.subscribe(val => {		
			
			if (this.eventsActive) this.unsubscribeAllEvents(formGroup);			
			var ivaValue = formGroup.get("ivaValue").value;			
			var decimalsPreu = formGroup.get("decimalsPreu").value;
			var preuSenseIva = val/(1+(ivaValue/100));
			formGroup.get("fixedPvp").setValue(preuSenseIva);
			var preuSenseIvaDecimals = preuSenseIva.toFixed(decimalsPreu);
			formGroup.get("pvp").setValue(preuSenseIvaDecimals);			
			formGroup.get("fixedPreuAmbIva").setValue(val);
			var decimalsPreuIva = formGroup.get("decimalsPreuIva").value;
			var preuAmbIva = parseFloat(val).toFixed(decimalsPreuIva);			
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
		public ivesService: IvesService) {
			
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
			}
		});		
	
		this.setConfigExternalFormComponents([
			{ resourceName: 'iva', component: IvesFormComponent }		
		]);
	}

}