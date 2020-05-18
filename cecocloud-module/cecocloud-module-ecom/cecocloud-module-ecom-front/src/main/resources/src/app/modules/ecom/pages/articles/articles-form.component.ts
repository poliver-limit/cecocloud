import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormBaseComponent } from 'base-angular';

import { ArticlesService } from './articles.service';
import { IvesFormComponent } from '../ives/ives-form.component';

@Component( {
	templateUrl: 'articles-form.html'
} )
export class ArticlesFormComponent extends BngFormBaseComponent {
	
    constructor(
		activatedRoute: ActivatedRoute,
        public articlesService: ArticlesService) {
		super(activatedRoute);		
	
		this.setConfigExternalFormComponents([
			{ resourceName: 'iva', component: IvesFormComponent }		
		]);
	}

}