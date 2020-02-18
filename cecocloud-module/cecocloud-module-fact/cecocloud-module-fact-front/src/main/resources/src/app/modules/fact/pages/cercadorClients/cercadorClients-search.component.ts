import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

//import { FormControl } from '@angular/forms';

import { CercadorClientsService } from './cercadorClients.service';

@Component( {
	templateUrl: 'cercadorClients-search.html'
} )

export class CercadorClientsSearchComponent {

//	nameControl = new FormControl('');

	extraFiltersHide = true;
	
	public extraFiltersShowHide() {		
		if (this.extraFiltersHide) {
			console.log ("mostrant");
			this.extraFiltersHide = false;
		}
		else {
			console.log ("ocultant");
			this.extraFiltersHide = true;
		}		
	}
	
    formConfig: BngFormConfig = {
    }

 	datagridConfig = {    
        columnFiltersEnabled: false
    };

    constructor(
        public cercadorClientsService: CercadorClientsService ) { }

}