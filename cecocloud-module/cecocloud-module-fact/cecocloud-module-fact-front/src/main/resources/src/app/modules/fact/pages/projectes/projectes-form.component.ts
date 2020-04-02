import { ViewChild, Component } from "@angular/core";
import { BngForm, BngFormBaseComponent, BngFormConfig, BngFormErrorMessages } from "base-angular";
import { ActivatedRoute } from '@angular/router';

import { ProjectesService } from "./projectes.service";

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



@Component({
  templateUrl: 'temp02.html'
})


export class ProjectesFormComponent extends BngFormBaseComponent {
	
	@ViewChild(BngForm) form: BngForm;
	
  	formConfig: BngFormConfig = {};

	errorMessages: BngFormErrorMessages = {
		secondDateOlder: {
		messageKey: 'resource.projecte.error.secondDateOlder'		
		}
	}
	
	public clientValue: string;
	
	onFormGroupChange(formGroup: FormGroup) {		
//		this.form.getInputField('client').setCustomFilter('nomComercial=ic=C*');
		formGroup.setValidators(firstDateOlderThanSecondDate('dataInici','dataFi'));			
		formGroup.valueChanges.subscribe(val => {
//			console.log(clientValue);			
		})	
//		this.form.formGroup.get('descripcio').valueChanges.subscribe(val => {
//			debugger;
////			me.form.getInputField('client').setCustomFilter('nomComercial=ic=C*');
//		})
	}
	
	onResourceLoad(event: any) {
//		debugger;
	}
	
//	ngOnInit() {
//		debugger;
//	}
	
	constructor(
		activatedRoute: ActivatedRoute,
		public projectesService: ProjectesService) {
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
		}
}
