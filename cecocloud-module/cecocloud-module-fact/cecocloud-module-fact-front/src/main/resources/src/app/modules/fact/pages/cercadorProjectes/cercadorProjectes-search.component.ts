import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

//import { FormControl } from '@angular/forms';

import { CercadorProjectesService } from './cercadorProjectes.service';

@Component( {
	templateUrl: 'cercadorProjectes-search.html'
} )

export class CercadorProjectesSearchComponent {
	
	cleanFilters(event: any) {
		
	}
	
	toFilter () {
		
	}

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
        public cercadorProjectesService: CercadorProjectesService ) { }

}