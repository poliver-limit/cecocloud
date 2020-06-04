import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormConfig, BngFormBaseComponent } from 'base-angular';
import { BngDatagridConfig } from 'base-angular';

import { ArticlesFamiliaService } from './articlesFamilia.service';

// Per a generar manteniments de tipus 1
import { ArticlesFamiliaEmpresaService } from '../articlesFamiliaEmpresa/articlesFamiliaEmpresa.service';

@Component( {
	templateUrl: 'articlesFamilia-form.html'
} )
export class ArticlesFamiliaFormComponent extends BngFormBaseComponent {
	
	public modificant: boolean = false;
	
	gridsEditables: boolean = true;

    formConfig: BngFormConfig = {
    }

	datagridConfig = {	
        columnFiltersEnabled: false
    };

	articlesFamiliaEmpresaDatagridConfig: BngDatagridConfig = {
		mode: 'form',		
		columns: [ {
			field: 'empresa'
		}, {
			field: 'web'
		}]
	};    

//	 Aconseguim que només es llistin els ArticlesFamiliaEmpresa de l'ArticleFamilia que estem editant	
	showArticleFamiliaEmpresaGrid : boolean = false;
	articleFamilia: any;
	onResourceLoad(articleFamilia: any) {		
		this.articleFamilia = articleFamilia;				
		this.articlesFamiliaEmpresaDatagridConfig.fixedFilter = 'articleFamilia.codi==' + this.articleFamilia.codi;			
		this.showArticleFamiliaEmpresaGrid = true;				
	}

    constructor(
		activatedRoute: ActivatedRoute,
        public articlesFamiliaService: ArticlesFamiliaService,
		public articlesFamiliaEmpresaService: ArticlesFamiliaEmpresaService
	) { 
		
		super(activatedRoute);		
		activatedRoute.params.subscribe((params) => {
			if (params.id) {
				this.modificant = true;
				
				this.articlesFamiliaEmpresaDatagridConfig.fixedRowData = {
					articleFamilia: {
						id: params.id,
						description: undefined
					}
				};					
			}
		});
	}

}