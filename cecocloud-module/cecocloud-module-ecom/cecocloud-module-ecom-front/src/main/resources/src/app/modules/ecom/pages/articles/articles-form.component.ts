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

@Component( {
	templateUrl: 'articles-form.html'
} )
export class ArticlesFormComponent extends BngFormBaseComponent {
	
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
			field: 'referenciaSequencial'
		}, {
			field: 'descripcio'
		}, {
			field: 'web'
		}, {
			field: 'rutaInforme'
		}]
	};
	
	articlesTraduccioDatagridConfig: BngDatagridConfig = {
		mode: 'form',		
		columns: [ {
			field: 'idioma'
		}, {
			field: 'descripcio'
		}]
	};   
	
	//	 Aconseguim que només es llistin els ArticlesFamiliaEmpresa de l'ArticleFamilia que estem editant
	showArticleInformacioGrid : boolean = false;
	showArticleTraduccioGrid : boolean = false;
	article: any;	
	onResourceLoad(article: any) {		
		this.article = article;		
		this.articlesInformacioDatagridConfig.fixedFilter = 'article.codi==' + this.article.codi;
		this.showArticleInformacioGrid = true;
		this.articlesTraduccioDatagridConfig.fixedFilter = 'article.codi==' + this.article.codi;							
		this.showArticleTraduccioGrid = true;		
	}	 

    constructor(
		activatedRoute: ActivatedRoute,
        public articlesService: ArticlesService,
		public articlesInformacioService: ArticlesInformacioService,
		public articlesTraduccioService: ArticlesTraduccioService) {
			
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
			}
		});		
	
		this.setConfigExternalFormComponents([
			{ resourceName: 'iva', component: IvesFormComponent }		
		]);
	}

}