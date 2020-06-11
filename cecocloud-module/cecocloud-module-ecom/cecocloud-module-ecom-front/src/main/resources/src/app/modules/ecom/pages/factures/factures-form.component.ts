import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormConfig, BngFormBaseComponent } from 'base-angular';
import { BngDatagridConfig } from 'base-angular';

import { FacturesService } from './factures.service';

@Component( {
	templateUrl: 'factures-form.html'
} )
export class FacturesFormComponent extends BngFormBaseComponent {

	public modificant: boolean = false;
	
	gridsEditables: boolean = true;
	
    formConfig: BngFormConfig = {
    }

	datagridConfig = {	
        columnFiltersEnabled: false
    };		
	
	constructor(
		activatedRoute: ActivatedRoute,
		public facturesService: FacturesService
	) {
		super(activatedRoute);
		
		activatedRoute.params.subscribe((params) => {
			if (params.id) {				
				this.modificant = true;			
			}
		});
				
	}

}